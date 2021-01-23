package ru.dobrenky.blog.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dobrenky.blog.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
