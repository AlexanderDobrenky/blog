package ru.dobrenky.blog.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dobrenky.blog.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
