package ru.kpfu.itis.greenmapc.service;

import ru.kpfu.itis.greenmapc.form.ScheduleForm;
import ru.kpfu.itis.greenmapc.model.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule saveFromForm(ScheduleForm form);

    List<Schedule> findAll();
}
