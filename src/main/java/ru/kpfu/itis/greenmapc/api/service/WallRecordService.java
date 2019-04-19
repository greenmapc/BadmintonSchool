package ru.kpfu.itis.greenmapc.api.service;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.greenmapc.api.util.VkApiClient;
import ru.kpfu.itis.greenmapc.model.VkWallRecord;
import ru.kpfu.itis.greenmapc.repository.VkWallRecordRepository;
import ru.kpfu.itis.greenmapc.repository.VkWallRecordRepositoryCustomImpl;

import javax.persistence.NoResultException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class WallRecordService {

    private VkWallRecordRepository wallRecordRepository;


    @Autowired
    public WallRecordService(VkWallRecordRepository wallRecordRepository) {
        this.wallRecordRepository = wallRecordRepository;
    }

    public boolean saveNewRecord(List<VkWallRecord> wallRecords) {
        try {
            wallRecordRepository.saveAll(wallRecords);
            wallRecordRepository.flush();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public List<VkWallRecord> getNewWallRecords() {
        return wallRecordsFilter();
    }

    private List<VkWallRecord> wallRecordsFilter() {
        List<VkWallRecord> records = VkApiClient.getGroupWallRecords();

        long lastRecordUnixtime = 0;
        try {
            lastRecordUnixtime = wallRecordRepository.findTopByDate().getDate().getTime();
        } catch (NoResultException e) {

        }

        int border = 0;
        for(VkWallRecord record : records) {
            if(record.getDate().getTime() > lastRecordUnixtime) {
                border ++;
            }
        }

        return records.subList(0, border);
    }

}
