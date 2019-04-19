package ru.kpfu.itis.greenmapc.api.util;

public class VkRequest {
    public static final String METHOD_URL = "https://api.vk.com/method/%s&access_token=%s";
    public static final String GET_GROUP_WALL_RECORDS = "wall.get?owner_id=-%s&offset=0&count=10&version=5.92";
}
