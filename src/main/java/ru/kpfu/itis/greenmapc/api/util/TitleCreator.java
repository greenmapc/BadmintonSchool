package ru.kpfu.itis.greenmapc.api.util;

public class TitleCreator {

    private TitleCreator() {}

    public static String create(String text) {
        int textSize = text.length();
        int border = 0;

        boolean screening = false;
        int countScreening = 0;

        for(int i = 0; i < textSize; i ++, border ++) {
            char currentChar = text.charAt(i);
            if(currentChar == '«' || currentChar == '\"') {
                screening = true;
                countScreening ++;
            }

            if(currentChar == '»' || currentChar == '\"') {
                countScreening --;
                if(countScreening == 0) {
                    screening = false;
                }
            }

            if(!screening) {
                if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
                    border++;
                    break;
                }

                if (currentChar == '<') {
                    break;
                }
            }
        }
        return text.substring(0, border);
    }
}
