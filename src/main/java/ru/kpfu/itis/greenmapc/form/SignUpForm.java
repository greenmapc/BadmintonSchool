package ru.kpfu.itis.greenmapc.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.kpfu.itis.greenmapc.util.validAnnotation.FieldMatch;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@ToString
@NoArgsConstructor
@FieldMatch.List({
        @FieldMatch(firstField = "password", secondField = "repeatPassword")
})
public class SignUpForm {
    @Pattern(regexp = "[A-Za-z0-9_]{3,16}", message = "{login.incorrect}")
    @NotNull(message = "{login.incorrect}")
    private String login;

    @Pattern(regexp = "[A-Za-z0-9_]{6,16}", message = "{password.incorrect}")
    @NotNull(message = "{password.incorrect}")
    private String password;

    private String repeatPassword;

    @NotBlank(message = "{emptyFields}")
    private String name;

    @NotBlank(message = "{emptyFields}")
    private String surname;

    @NotNull(message = "{emptyFields}")
    private String type;

    private boolean emptyFieldsConstraint;
}
