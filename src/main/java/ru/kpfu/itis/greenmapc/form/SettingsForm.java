package ru.kpfu.itis.greenmapc.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
public class SettingsForm {

    @NotBlank(message = "{update.emptyFields}")
    private String name;

    @NotBlank(message = "{update.emptyFields}")
    private String surname;

    private String patronymic;

    private String birthday;

    @Pattern(regexp = "(|[A-Za-z0-9_.]+@[A-Za-z0-9_.]+)", message = "{email.incorrect}")
    private String email;

    @Pattern(regexp = "(|^9[0-9]{9})", message = "{number.incorrect}")
    private String number;

    private List<Group> choosingGroups;

    private Group choosingGroup;


    public void buildByUser(User user) {
        if(name == null && surname == null && patronymic == null && birthday == null && email == null && number == null) {
            this.name = user.getName();
            this.surname = user.getSurname();
            this.patronymic = user.getPatronymic();
            this.number = user.getContactNumber();
            this.email = user.getEmail();
            this.birthday = user.getBirthday() != null ? user.getBirthday().toString() : "";
        }
    }

    private boolean emptyFieldsConstraint;

}