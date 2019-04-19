package ru.kpfu.itis.greenmapc.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;
        import ru.kpfu.itis.greenmapc.model.VkWallRecord;

@Repository
public interface VkWallRecordRepository extends JpaRepository<VkWallRecord, Long>, VkWallRecordRepositoryCustom {
}
