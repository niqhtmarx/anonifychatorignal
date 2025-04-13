package io.github.niqhtmarx.anonifychat.repository;
import io.github.niqhtmarx.anonifychat.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepository extends JpaRepository<Post, Long> {}