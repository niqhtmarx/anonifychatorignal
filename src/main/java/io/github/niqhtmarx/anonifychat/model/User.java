package io.github.niqhtmarx.anonifychat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Objects;
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank
    @Column(unique = true, nullable = false)
    private String anonId;
    @Column
    private boolean matched;
    @Column
    private LocalDateTime createdAt;

    public User() {
    }

    public User(long id, String anonId, boolean matched, LocalDateTime createdAt) {
        this.anonId = anonId;
        this.matched = matched;
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnonId() {
        return anonId;
    }

    public void setAnonId(String anonId) {
        this.anonId = anonId;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && matched == user.matched && Objects.equals(anonId, user.anonId) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, anonId, matched, createdAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", annoid='" + anonId + '\'' +
                ", matched=" + matched +
                ", createdAt=" + createdAt +
                '}';
    }
}


