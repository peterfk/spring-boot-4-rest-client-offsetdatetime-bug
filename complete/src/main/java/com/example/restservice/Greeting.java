package com.example.restservice;

import java.time.OffsetDateTime;

public class Greeting {

    private  long id;
    private String content;
    private OffsetDateTime createdAt;

    public Greeting() {}

    public Greeting(long id, String content, OffsetDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Greeting{" +
            "id=" + id +
            ", content='" + content + '\'' +
            ", createdAt=" + createdAt +
            '}';
    }
}
