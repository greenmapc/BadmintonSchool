package ru.kpfu.itis.greenmapc.repository;

import ru.kpfu.itis.greenmapc.model.VkWallRecord;

import java.util.List;

public interface VkWallRecordRepositoryCustom {
    VkWallRecord findTopByDate();
    List<VkWallRecord> findAllPagination(int offset, int limit);
}
