package ru.kpfu.itis.greenmapc.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class WeekdaysListCreator {

    private WeekdaysListCreator() {
    }

    public static Map<String, String> create() {
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
}
