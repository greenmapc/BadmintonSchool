package ru.kpfu.itis.greenmapc.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Pointcut;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.greenmapc.form.ScheduleForm;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.Schedule;

import java.util.logging.Logger;

@Aspect
@Component
public class AdminLoggingAspect {
    private Logger LOGGER = Logger.getLogger(AdminLoggingAspect.class.getName());

    @AfterReturning(pointcut = "execution(* ru.kpfu.itis.greenmapc.service.GroupService.update(..))", returning = "value")
    public void groupUpdate(JoinPoint joinPoint, Object value) {
        if((boolean) value) {
            Group group = (Group) joinPoint.getArgs()[0];
            LOGGER.info("Обновлена группа номер " + group.getGroupNumber());
        }
    }

    @AfterReturning(pointcut = "execution(* ru.kpfu.itis.greenmapc.service.GroupService.save(..))", returning = "value")
    public void groupCreate(JoinPoint joinPoint, Object value) {
        if((boolean) value) {
            Group group = (Group) joinPoint.getArgs()[0];
            LOGGER.info("Создана новая группа. ID: " + group.getId());

        }
    }

    @AfterReturning(pointcut = "execution (* ru.kpfu.itis.greenmapc.service.ScheduleService.saveFromForm(..))", returning = "value")
    public void scheduleCreate(JoinPoint joinPoint, Object value) {
        if ((boolean) value) {
            ScheduleForm schedule = (ScheduleForm) joinPoint.getArgs()[0];
            LOGGER.info("Создано новое расписание: " +
                    schedule.getTime() + " " +
                    schedule.getWeekday());
        }
    }


}
