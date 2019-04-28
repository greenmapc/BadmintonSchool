package ru.kpfu.itis.greenmapc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "group_schedule",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )

    private Set<Schedule> scheduleSet = new HashSet<>();

    @OneToMany(mappedBy = "group")
    private Set<User> participants = new HashSet<>();

}
