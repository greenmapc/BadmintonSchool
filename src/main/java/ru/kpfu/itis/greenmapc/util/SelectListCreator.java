package ru.kpfu.itis.greenmapc.util;

import ru.kpfu.itis.greenmapc.model.Schedule;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SelectListCreator {

    private SelectListCreator() {
    }

    public static Map<String, String> weekdaysCreate() {
        Map<String, String> weekdayMap = new LinkedHashMap<>();
        weekdayMap.put("ПН", "Понедельник");
        weekdayMap.put("ВТ", "Вторник");
        weekdayMap.put("СР", "Среда");
        weekdayMap.put("ЧТ", "Четверг");
        weekdayMap.put("ПТ", "Пятница");
        weekdayMap.put("СБ", "Суббота");
        weekdayMap.put("ВС", "Воскресенье");

        return weekdayMap;
    }

    public static Map<String, String> scheduleCreate(List<Schedule> scheduleList) {
        Map<String, String> scheduleMap = new LinkedHashMap<>();

        for(Schedule schedule : scheduleList) {
            String scheduleTime = schedule.getTime().toString();
            String scheduleString = scheduleTime.substring(0, scheduleTime.length() - 3) + " " + schedule.getWeekday();
            scheduleMap.put(String.valueOf(schedule.getId()), scheduleString);
        }
        return scheduleMap;
    }
}
