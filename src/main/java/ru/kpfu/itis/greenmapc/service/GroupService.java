package ru.kpfu.itis.greenmapc.service;

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
    void createPrototype(Group original, Group prototype);

    boolean update(Group group);
}
