package ru.kpfu.itis.greenmapc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.greenmapc.dto.GroupScheduleDto;
import ru.kpfu.itis.greenmapc.exception.CreatingException;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.Schedule;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.repository.GroupRepository;

import java.sql.Time;
import java.util.*;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    public Optional<Group> getGroupByNumber(int groupNumber) {
        return groupRepository.findByGroupNumber(groupNumber);
    }

    public Map<String, String> getAllEmptyGroupNumbersWithUsersGroup(User user) {
        Map<String, String> result = new HashMap();

        List<Group> groupList = groupRepository.findAllByCoachIs(null);
        groupList.addAll(groupRepository.findAllByCoachIs(user));
        for(Group group : groupList) {
            result.put(String.valueOf(group.getGroupNumber()), String.valueOf(group.getGroupNumber()));
        }
        return result;
    }

    public Map<String, String> getAllMapGroups() {
        Map<String, String> result = new HashMap();

        List<Group> groupList = groupRepository.findAll();
        for(Group group : groupList) {
            result.put(String.valueOf(group.getGroupNumber()), String.valueOf(group.getGroupNumber()));
        }
        return result;
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public void createPrototype(Group original, Group prototype) {
        prototype.setId(original.getId());
        prototype.setGroupNumber(original.getGroupNumber());
        prototype.setAgeCategory(original.getAgeCategory());
        prototype.setCoach(original.getCoach());
        prototype.setParticipants(original.getParticipants());
        prototype.setScheduleSet(original.getScheduleSet());
    }

    public Group update(Group group) {
        Group dbGroup = groupRepository.findById(group.getId()).get();
        group.setCoach(dbGroup.getCoach());
        group.setParticipants(dbGroup.getParticipants());

        try {
            if(group.getScheduleSet().isEmpty()) {
                groupRepository.updateGroup(group.getAgeCategory(), group.getGroupNumber(), group.getId());
                return group;
            } else {
                return groupRepository.save(group);
            }
        } catch (DataIntegrityViolationException e) {
            throw new CreatingException("Неудачная попытка обновления группы. ID: " + group.getId());
        }
    }

    public Group save(Group group) {

        try {
            return groupRepository.save(group);
        } catch (DataIntegrityViolationException e) {
            throw new CreatingException("Неудачная попытка создания группы");
        }
    }

    public List<GroupScheduleDto> getSchedule(String sortBy) {
        List<Group> groups = groupRepository.findAllWithSchedule();

        List<GroupScheduleDto> dtos = new ArrayList<>();
        for(Group group : groups) {
            for(Schedule schedule : group.getScheduleSet()) {
                dtos.add(GroupScheduleDto.builder()
                        .groupNumber(group.getGroupNumber())
                        .weekday(schedule.getWeekday())
                        .time(schedule.getTime())
                        .build());
            }
        }

        try {
            switch (sortBy) {
                case "group" :
                    dtos.sort(Comparator.comparingInt(GroupScheduleDto::getGroupNumber));
                    break;
                case "time" :
                    dtos.sort(Comparator.comparing(o -> o.getTime().toString()));
            }
        } catch (NullPointerException e) { }

        return dtos;
    }

    @Autowired
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
