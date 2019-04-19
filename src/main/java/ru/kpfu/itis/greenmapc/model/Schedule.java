package ru.kpfu.itis.greenmapc.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "weekday")
    private String weekday;

    @ManyToMany(mappedBy = "scheduleSet")
    private Set<Group> groups;

}
