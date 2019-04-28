package ru.kpfu.itis.greenmapc.util.freemarker;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

public class TimeNormalization implements TemplateMethodModelEx {

    @Override
    public Object exec(List list) throws TemplateModelException {
        String time = list.get(0).toString();

        return time.substring(0, time.length() - 3);
    }
}
