package ru.kpfu.itis.greenmapc.service;

import ru.kpfu.itis.greenmapc.model.VkWallRecord;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    List<VkWallRecord> getNews(int pageNumber);
    Optional<VkWallRecord> getItem(long id);

    boolean existNextPage(int pageNumber);
}
