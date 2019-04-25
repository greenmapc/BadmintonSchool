package ru.kpfu.itis.greenmapc.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.greenmapc.config.RootConfiguration;
import ru.kpfu.itis.greenmapc.dto.GroupScheduleDTO;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.Schedule;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {RootConfiguration.class}
)

public class GroupRepositoryTest {
    @Resource
    private ScheduleRepository scheduleRepository;

    @Resource
    private GroupRepository groupRepository;

    @Test
    public void test() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<Group> groups = new ArrayList<>();
        for (Schedule schedule : schedules) {
            System.out.println(schedule.getId());
            groups = groupRepository.findGroupByScheduleId(schedule.getId());
            GroupScheduleDTO groupScheduleDTO = new GroupScheduleDTO(schedule, groups);
            System.out.println(groupScheduleDTO);
        }

    }
}