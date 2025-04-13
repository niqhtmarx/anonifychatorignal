package io.github.niqhtmarx.anonifychat.repository;
import io.github.niqhtmarx.anonifychat.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {}