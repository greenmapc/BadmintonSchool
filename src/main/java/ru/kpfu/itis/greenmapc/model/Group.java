package ru.kpfu.itis.greenmapc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "school_group")
@Data
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "group_number", unique = true)
    private Integer groupNumber;

    @Column(name = "age_category")
    private String ageCategory;

    @ManyToOne
    @JoinColumn(name = "coach", referencedColumnName = "id")
    private User coach;

    @ManyToMany
    @JoinTable(
            name = "group_schedule",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    private Set<Schedule> scheduleSet;

    @OneToMany(mappedBy = "group")
    private Set<User> participants;

}