package ru.dobrenky.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.dobrenky.blog.exception.UserAlreadyExistException;
import ru.dobrenky.blog.model.User;
import ru.dobrenky.blog.model.dto.UserDTO;
import ru.dobrenky.blog.repository.UserRepository;

@Service
public class UserService implements ru.dobrenky.blog.service.UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, MessageSource messageSource) {
        this.userRepository = userRepository;
    }

    @Override
    public User createNewUserAccount(UserDTO user) throws UserAlreadyExistException {
        System.out.println(userRepository.findByEmail(user.getEmail()));
        if(userRepository.findByEmail(user.getEmail()) == null) {
            return userRepository.save(new User(user.getUserName(), user.getEmail(), user.getPassword()));
        } else {
            throw new UserAlreadyExistException();
        }
    }
}
