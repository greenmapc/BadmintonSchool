package ru.kpfu.itis.greenmapc.service;

import ru.kpfu.itis.greenmapc.dto.GroupScheduleDto;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GroupService {
    Optional<Group> getGroupByNumber(int groupNumber);
    Map<String, String> getAllEmptyGroupNumbersWithUsersGroup(User user);
    Map<String, String> getAllMapGroups();
    List<Group> getAllGroups();

    List<GroupScheduleDto> getSchedule(String sortBy);

    void createPrototype(Group original, Group prototype);

    Group update(Group group);
    Group save(Group group);
}
