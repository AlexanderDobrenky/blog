package ru.dobrenky.blog.service;

import ru.dobrenky.blog.exception.UserAlreadyExistException;
import ru.dobrenky.blog.model.User;
import ru.dobrenky.blog.model.dto.UserDTO;

public interface UserService {
    User createNewUserAccount(UserDTO user) throws UserAlreadyExistException;
}
