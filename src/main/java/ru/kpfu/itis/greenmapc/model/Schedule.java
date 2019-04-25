package ru.kpfu.itis.greenmapc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "schedule")
@Data
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "time", columnDefinition = "time")
    private Time time;

    @Column(name = "weekday")
    private String weekday;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "scheduleSet")
    private Set<Group> groups;

}
