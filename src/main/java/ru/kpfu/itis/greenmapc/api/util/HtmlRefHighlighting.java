package ru.kpfu.itis.greenmapc.api.util;

import java.util.Arrays;

public class HtmlRefHighlighting {
    private HtmlRefHighlighting() {}

    public static String highlighting(String text) {
        StringBuilder result = new StringBuilder("");
        int last = 0;

        while(text.indexOf("http", last) != -1) {
            int index = text.indexOf("http", last);
            int r = index;
            result.append(text, last, r).append("<a href='");

            for( ; r < text.length() && text.charAt(r) != ' ' && text.charAt(r) != '<' && text.charAt(r) != '!' && text.charAt(r) != ',';
                r ++) {
            }

            result.append(text, index, r).append("'>").append(text, index, r).append("</a>");
            last = r;
        }

        result.append(text, last, text.length());
        return result.toString();
    }
}
