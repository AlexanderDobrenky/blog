package ru.dobrenky.blog.validator;

import ru.dobrenky.blog.model.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserDTO> {
    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        return userDTO.getPassword().equals(userDTO.getConfirmPassword());
    }

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }
}
