package io.github.niqhtmarx.anonifychat.repository;
import io.github.niqhtmarx.anonifychat.model.ChatSession;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ChatSessionRepository extends JpaRepository<ChatSession, Long> {}