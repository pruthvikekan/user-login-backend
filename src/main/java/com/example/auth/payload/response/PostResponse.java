package com.example.auth.payload.response;

import java.time.LocalDateTime;

public class PostResponse {
    private Long id;
    private String description;
    private String photo;
    private LocalDateTime createdAt;
    private String authorName;
    private String authorPhoto;

    public PostResponse(Long id, String description, String photo, LocalDateTime createdAt, String authorName, String authorPhoto) {
        this.id = id;
        this.description = description;
        this.photo = photo;
        this.createdAt = createdAt;
        this.authorName = authorName;
        this.authorPhoto = authorPhoto;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getAuthorPhoto() { return authorPhoto; }
    public void setAuthorPhoto(String authorPhoto) { this.authorPhoto = authorPhoto; }
}
