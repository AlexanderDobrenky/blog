package ru.dobrenky.blog.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dobrenky.blog.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
