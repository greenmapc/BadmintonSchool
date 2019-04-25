package ru.kpfu.itis.greenmapc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.Schedule;

import java.sql.Time;
import java.util.List;

@Data
public class GroupScheduleDTO {
    private String weekday;
    private String time;

    public GroupScheduleDTO(Schedule schedule, List<Group> groups) {
        this.weekday = schedule.getWeekday();
        String stringTime = String.valueOf(schedule.getTime());
        this.time = stringTime.substring(0, stringTime.length() - 3);
        this.groups = groups;
    }

    private List<Group> groups;
}
