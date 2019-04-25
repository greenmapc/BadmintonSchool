package ru.kpfu.itis.greenmapc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.greenmapc.dto.GroupScheduleDTO;
import ru.kpfu.itis.greenmapc.form.ScheduleForm;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.Schedule;
import ru.kpfu.itis.greenmapc.repository.GroupRepository;
import ru.kpfu.itis.greenmapc.repository.ScheduleRepository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;
    private GroupRepository groupRepository;

    public boolean saveFromForm(ScheduleForm form) {
        Schedule schedule = new Schedule();
        schedule.setWeekday(form.getWeekday());
        schedule.setTime(Time.valueOf(form.getTime() + ":00"));

        try {
            scheduleRepository.save(schedule);
        } catch (DataIntegrityViolationException e) {
            return false;
        }

        return true;
    }

    //ToDo: one query instead two
    public List<GroupScheduleDTO> getSchedule() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<GroupScheduleDTO> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            List<Group> groups;
            groups = groupRepository.findGroupByScheduleId(schedule.getId());
            dtos.add(new GroupScheduleDTO(schedule, groups));
         }

        return dtos;
    }

    @Autowired
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Autowired
    public void setScheduleRepository(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
}
