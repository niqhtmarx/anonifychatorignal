package io.github.niqhtmarx.anonifychat.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "chat_sessions")
public class ChatSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String user1Id;

    @Column(nullable = false)
    private String user2Id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ElementCollection
    private List<String> messages = new ArrayList<>();

    public ChatSession() {}

    public ChatSession(String user1Id, String user2Id) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.createdAt = LocalDateTime.now();
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getUser1Id() { return user1Id; }
    public void setUser1Id(String user1Id) { this.user1Id = user1Id; }
    public String getUser2Id() { return user2Id; }
    public void setUser2Id(String user2Id) { this.user2Id = user2Id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public List<String> getMessages() { return messages; }
    public void setMessages(List<String> messages) { this.messages = messages; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChatSession that = (ChatSession) o;
        return id == that.id && Objects.equals(user1Id, that.user1Id) &&
                Objects.equals(user2Id, that.user2Id) && Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user1Id, user2Id, createdAt, messages);
    }

    @Override
    public String toString() {
        return "ChatSession{" +
                "id=" + id +
                ", user1Id='" + user1Id + '\'' +
                ", user2Id='" + user2Id + '\'' +
                ", createdAt=" + createdAt +
                ", messages=" + messages +
                '}';
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}