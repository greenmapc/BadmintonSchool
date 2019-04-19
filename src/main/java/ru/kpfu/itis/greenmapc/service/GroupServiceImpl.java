package ru.kpfu.itis.greenmapc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.repository.GroupRepository;

import java.util.*;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    @Override
    public Optional<Group> getGroupByNumber(int groupNumber) {
        return groupRepository.findByGroupNumber(groupNumber);
    }

    @Override
    public Map<String, String> getAllEmptyGroupNumbersWithUsersGroup(User user) {
        Map<String, String> result = new HashMap();

        List<Group> groupList = groupRepository.findAllByCoachIs(null);
        groupList.addAll(groupRepository.findAllByCoachIs(user));
        for(Group group : groupList) {
            result.put(String.valueOf(group.getGroupNumber()), String.valueOf(group.getGroupNumber()));
        }
        return result;
    }

    @Override
    public Map<String, String> getAllGroups() {
        Map<String, String> result = new HashMap();

        List<Group> groupList = groupRepository.findAll();
        for(Group group : groupList) {
            result.put(String.valueOf(group.getGroupNumber()), String.valueOf(group.getGroupNumber()));
        }
        return result;
    }

    @Autowired
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
