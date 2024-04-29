package com.jwt.model;

import java.time.LocalDateTime;

public class UpdatePostRequest {

    private Integer postId;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }



    // Getters and setters
}

