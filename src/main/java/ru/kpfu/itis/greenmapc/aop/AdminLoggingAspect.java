package ru.kpfu.itis.greenmapc.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.greenmapc.exception.CreatingException;
import ru.kpfu.itis.greenmapc.form.ScheduleForm;
import ru.kpfu.itis.greenmapc.model.Group;

import java.util.logging.Logger;

@Aspect
@Component
public class AdminLoggingAspect {
    private Logger LOGGER = Logger.getLogger(AdminLoggingAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* ru.kpfu.itis.greenmapc.service.GroupService.save(..))", throwing = "e")
    public void failedGroupSaving(CreatingException e) {
        LOGGER.info(e.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* ru.kpfu.itis.greenmapc.service.GroupService.update(..))", throwing = "e")
    public void failedGroupUpdating(CreatingException e) {
        LOGGER.info(e.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* ru.kpfu.itis.greenmapc.service.ScheduleService.saveFromForm(..))", throwing = "e")
    public void failedScheduleSaving(CreatingException e) {
        LOGGER.info(e.getMessage());
    }


    @AfterReturning(pointcut = "execution(* ru.kpfu.itis.greenmapc.service.GroupService.update(..))")
    public void groupUpdate(JoinPoint joinPoint) {
        Group group = (Group) joinPoint.getArgs()[0];
        LOGGER.info("Обновлена группа номер " + group.getGroupNumber());
    }

    @AfterReturning(pointcut = "execution(* ru.kpfu.itis.greenmapc.service.GroupService.save(..))")
    public void groupCreate(JoinPoint joinPoint) {
        Group group = (Group) joinPoint.getArgs()[0];
        LOGGER.info("Создана новая группа. ID: " + group.getId());
    }

    @AfterReturning(pointcut = "execution (* ru.kpfu.itis.greenmapc.service.ScheduleService.saveFromForm(..))")
    public void scheduleCreate(JoinPoint joinPoint) {
        ScheduleForm schedule = (ScheduleForm) joinPoint.getArgs()[0];
        LOGGER.info("Создано новое расписание: " +
                schedule.getTime() + " " +
                schedule.getWeekday());
    }


}
