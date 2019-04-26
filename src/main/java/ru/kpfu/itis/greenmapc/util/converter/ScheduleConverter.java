package ru.kpfu.itis.greenmapc.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.kpfu.itis.greenmapc.model.Schedule;
import ru.kpfu.itis.greenmapc.repository.ScheduleRepository;

import java.util.Optional;

public class ScheduleConverter implements Converter<String, Schedule> {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule convert(String id) {
        Optional<Schedule> scheduleOptional = scheduleRepository.findById(Long.valueOf(id));
        return scheduleOptional.get();
    }
}
