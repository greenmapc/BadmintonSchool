package ru.kpfu.itis.greenmapc.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.repository.GroupRepository;

import java.util.*;

public class GroupConverter implements Converter<String, Group> {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group convert(String groupNumbers) {
        Optional<Group> group = groupRepository.findByGroupNumber(Integer.valueOf(groupNumbers));
        return group.get();
    }
}
