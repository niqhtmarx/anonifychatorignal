package io.github.niqhtmarx.anonifychat.model;

import io.github.niqhtmarx.anonifychat.model.ThreadEntity;
import io.github.niqhtmarx.anonifychat.model.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private ThreadEntity thread;  // Updated to ThreadEntity

    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private Boolean isEdited = false;

    private String title;

    private String imageUrl;

    @ElementCollection
    private List<String> tags;

    private Boolean isAnonymous = false;

    public Post() {

    }

    // Argument constructor
    public Post(Long id, User user, ThreadEntity thread, String content, LocalDateTime createdAt,
                LocalDateTime updatedAt, LocalDateTime deletedAt, Boolean isEdited,
                String title, String imageUrl, List<String> tags, Boolean isAnonymous) {
        this.id = id;
        this.user = user;
        this.thread = thread;  // Updated to ThreadEntity
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.isEdited = isEdited;
        this.title = title;
        this.imageUrl = imageUrl;
        this.tags = tags;
        this.isAnonymous = isAnonymous;
    }



    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ThreadEntity getThread() {
        return thread;  // Updated to ThreadEntity
    }

    public void setThread(ThreadEntity thread) {
        this.thread = thread;  // Updated to ThreadEntity
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Boolean getIsEdited() {
        return isEdited;
    }

    public void setIsEdited(Boolean isEdited) {
        this.isEdited = isEdited;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString method
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", thread=" + thread +  // Updated to ThreadEntity
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", isEdited=" + isEdited +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tags=" + tags +
                ", isAnonymous=" + isAnonymous +
                '}';
    }
}
