package ru.kpfu.itis.greenmapc.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScheduleForm {
    private String time;
    private String weekday;
}
