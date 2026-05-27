package com.example.auth.payload.request;

import jakarta.validation.constraints.NotBlank;

public class PostRequest {
    @NotBlank
    private String description;
    
    private String photo;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
