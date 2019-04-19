package ru.kpfu.itis.greenmapc.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import ru.kpfu.itis.greenmapc.model.VkWallRecord;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class VkApiClient {
    private static final String PROPERTIES_NAME = "api.properties";

    private static Logger LOGGER = Logger.getLogger(VkApiClient.class.getName());

    private static JsonRecordParser jsonRecordParser = new JsonRecordParser();

    private VkApiClient() {}

    public static List<VkWallRecord> getGroupWallRecords() {

        List<VkWallRecord> result = new ArrayList<>();

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream resourceStream = loader.getResourceAsStream(PROPERTIES_NAME);

            Properties properties = new Properties();
            properties.load(resourceStream);

            String accessToken = properties.getProperty("SERVICE_KEY");
            String groupId = properties.getProperty("GROUP_ID");

            String wallUrl = String.format(VkRequest.GET_GROUP_WALL_RECORDS, groupId);

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(String.format(VkRequest.METHOD_URL, wallUrl, accessToken));

            CloseableHttpResponse response = httpClient.execute(httpPost);
            String responseResult = readData(response);

            ObjectMapper mapper = new ObjectMapper();
            List<VkWallRecord> vkWallRecord = jsonRecordParser.parse(mapper.readTree(responseResult));
            result = vkWallRecord;

        } catch (NullPointerException e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            LOGGER.severe("CAN'T CONNECT TO VK");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            LOGGER.severe("FILE " + PROPERTIES_NAME + " NOT FOUND");
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.severe("CONNECTION FAILED");
            e.printStackTrace();
        }

        return result;
    }

    private static String readData(CloseableHttpResponse response) {
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;

        StringBuilder res = new StringBuilder();
        String line;

        try {
            inputStream = response.getEntity().getContent();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            while ((line = bufferedReader.readLine()) != null) {
                res.append(line);
            }

            inputStream.close();
        } catch (IOException e) {
            LOGGER.severe("CAN'T GET RESPONSE DATA");
            e.printStackTrace();
        }
        return res.toString();
    }
}
