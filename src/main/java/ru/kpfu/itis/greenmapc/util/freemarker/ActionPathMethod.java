package ru.kpfu.itis.greenmapc.util.freemarker;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;

public class ActionPathMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List list) throws TemplateModelException {
        if(list.size() < 1 || list.size() % 2 == 0) {
            throw new TemplateModelException("Wrong arguments");
        }

        String action = list.get(0).toString();
        MvcUriComponentsBuilder.MethodArgumentBuilder methodArgumentBuilder = MvcUriComponentsBuilder.fromMappingName(action);

        try {
            for (int i = 1; i < list.size() - 1; i += 2) {
                String index = list.get(i).toString();
                int intIndex = Integer.parseInt(index);
                methodArgumentBuilder.arg(intIndex, list.get(i + 1).toString());
            }
        } catch (IllegalArgumentException e) {
            throw new TemplateModelException("Wrong arguments");
        }

        return methodArgumentBuilder.build();
    }
}
