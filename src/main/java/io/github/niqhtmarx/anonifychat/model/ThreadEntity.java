package io.github.niqhtmarx.anonifychat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "threads")
public class ThreadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank
    @Size(max = 255, min = 1)
    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String anonId;

    @OneToMany(mappedBy = "thread",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Post> posts;

    public ThreadEntity() {

    }

    public ThreadEntity( String title,  String anonId, List<Post> posts) {
        this.title = title;
        this.createdAt = LocalDateTime.now();
        this.anonId = anonId;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getAnonId() {
        return anonId;
    }

    public void setAnonId(String anonId) {
        this.anonId = anonId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ThreadEntity that = (ThreadEntity) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(createdAt, that.createdAt) && Objects.equals(anonId, that.anonId) && Objects.equals(posts, that.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, createdAt, anonId, posts);
    }

    @Override
    public String toString() {
        return "ThreadEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                ", anonId='" + anonId + '\'' +
                ", posts=" + posts +
                '}';
    }
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
