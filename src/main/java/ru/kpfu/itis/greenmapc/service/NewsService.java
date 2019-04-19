package ru.kpfu.itis.greenmapc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.greenmapc.model.VkWallRecord;
import ru.kpfu.itis.greenmapc.repository.VkWallRecordRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    private VkWallRecordRepository vkWallRecordRepository;
    private final int RECORDS_COUNT = 6;

    @Autowired
    public NewsService(VkWallRecordRepository vkWallRecordRepository) {
        this.vkWallRecordRepository = vkWallRecordRepository;
    }



    public List<VkWallRecord> getNews(int pageNumber) {
        return vkWallRecordRepository.findAllPagination(pageNumber * 6, RECORDS_COUNT);
    }

    public boolean existNextPage(int pageNumber) {
        return vkWallRecordRepository.findAll().size() > (pageNumber + 1) * RECORDS_COUNT;
    }

    public Optional<VkWallRecord> getItem(long id) {
        return vkWallRecordRepository.findById(id);
    }
}
