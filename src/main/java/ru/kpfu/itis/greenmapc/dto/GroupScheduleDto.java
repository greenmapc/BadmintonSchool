package ru.kpfu.itis.greenmapc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.greenmapc.model.Group;

import java.sql.Time;

@Builder
@Data
public class GroupScheduleDto {
    private Integer groupNumber;
    private String weekday;
    private Time time;
}
