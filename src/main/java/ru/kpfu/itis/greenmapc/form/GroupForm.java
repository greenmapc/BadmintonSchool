package ru.kpfu.itis.greenmapc.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class GroupForm {

    private Long id;

    @NotNull
    private Integer groupNumber;

    @NotBlank
    private String ageCategory;

    private List<String> scheduleSet;
}
