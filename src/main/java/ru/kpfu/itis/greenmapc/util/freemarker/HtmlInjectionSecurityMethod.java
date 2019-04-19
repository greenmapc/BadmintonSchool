package ru.kpfu.itis.greenmapc.util.freemarker;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

public class HtmlInjectionSecurityMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List list) throws TemplateModelException {
        String text = list.get(0).toString();

        text = text.replace("&", "&#38;");
        text = text.replace(":", "&:58;");
        text = text.replace("\"", "&quot;");
        text = text.replace("<", "&lt;");
        text = text.replace(">", "&gt;");

        return text;
    }
}
