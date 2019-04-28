package ru.kpfu.itis.greenmapc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.greenmapc.exception.CreatingException;
import ru.kpfu.itis.greenmapc.form.ScheduleForm;
import ru.kpfu.itis.greenmapc.model.Schedule;
import ru.kpfu.itis.greenmapc.repository.ScheduleRepository;

import java.sql.Time;
import java.util.List;


@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    public Schedule saveFromForm(ScheduleForm form) {
        Schedule schedule = new Schedule();
        schedule.setWeekday(form.getWeekday());
        schedule.setTime(Time.valueOf(form.getTime() + ":00"));

        try {
            return scheduleRepository.save(schedule);
        } catch (DataIntegrityViolationException e) {
            throw new CreatingException("Неудачная попытка создания распиания");
        }
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Autowired
    public void setScheduleRepository(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
}
