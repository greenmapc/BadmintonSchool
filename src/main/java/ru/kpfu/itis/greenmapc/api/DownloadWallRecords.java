package ru.kpfu.itis.greenmapc.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.greenmapc.api.service.WallRecordService;
import ru.kpfu.itis.greenmapc.config.RootConfiguration;
import ru.kpfu.itis.greenmapc.model.VkWallRecord;

import java.util.List;
import java.util.logging.Logger;

public class DownloadWallRecords {
    private static final Logger LOGGER = Logger.getLogger(DownloadWallRecords.class.getName());
    public static void main(String[] args) {
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(RootConfiguration.class);

        WallRecordService wallRecordService = applicationContext.getBean(WallRecordService.class);

        while (true) {
            try {
                List<VkWallRecord> newWallRecords = wallRecordService.getNewWallRecords();

                if(wallRecordService.saveNewRecord(newWallRecords)) {
                    LOGGER.info("ALL NEW WALL RECORDS SAVED");
                } else {
                    LOGGER.info("NEW WALL RECORDS NOT SAVED");
                }

                Thread.sleep(1000*60*60);
            } catch (InterruptedException e) {
                LOGGER.severe("WALL RECORD LOADING FAILED");
                e.printStackTrace();
            }
        }
    }
}
