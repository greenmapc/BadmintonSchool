package ru.kpfu.itis.greenmapc.api.util;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.greenmapc.model.VkWallRecord;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@NoArgsConstructor
public class JsonRecordParser {


    public List<VkWallRecord> parse(JsonNode jsonNode) {

        String ATTACHMENT = "attachment";
        String PHOTO = "photo";
        String BIG_PHOTO = "src_big";

        List<VkWallRecord> result = new ArrayList<>();

        JsonNode data = null;
        try {
            data = jsonNode.get("response");
        } catch (NullPointerException e) {
            throw new NullPointerException("Answer return empty data");
        }

        Iterator<JsonNode> nodes = data.elements();
        nodes.next();

        while(nodes.hasNext()){
            JsonNode node = nodes.next();

            String text = "";
            String uriImage = "";

            Date date = new Date(Long.valueOf(node.get("date").asText()) * 1000);

            try {
                text = node.get("text").asText();
                uriImage = node.get(ATTACHMENT).get(PHOTO).get(BIG_PHOTO).asText();
            } catch (NullPointerException e) {}

            VkWallRecord wallRecord = new VkWallRecord();
            wallRecord.setText(HtmlRefHighlighting.highlighting(text));
            wallRecord.setDate(date);
            wallRecord.setTitle(TitleCreator.create(text));
            wallRecord.setImgURI(uriImage);

            result.add(wallRecord);
        }

        return result;
    }
}
