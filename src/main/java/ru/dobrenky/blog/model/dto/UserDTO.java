package ru.dobrenky.blog.model.dto;

import ru.dobrenky.blog.validator.PasswordMatches;
import ru.dobrenky.blog.validator.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordMatches(message = "{form.registration.validation.invalidPassword}")
public class UserDTO {
    @NotNull
    @NotEmpty
    private String userName;

    @ValidEmail(message = "{form.registration.validation.invalidEmail}")
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String confirmPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
