package com.tericcabrel.passify.models;

import javax.persistence.*;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class Model {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, insertable = false, updatable = false, nullable = false)
    protected Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    protected ZonedDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    protected ZonedDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public Model setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Model setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }
}
