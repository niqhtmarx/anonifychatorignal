package io.github.niqhtmarx.anonifychat.repository;
import io.github.niqhtmarx.anonifychat.model.ThreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ThreadRepository extends JpaRepository<ThreadEntity, Long> {}