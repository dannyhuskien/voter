package com.dcsn.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "states")
public class State {
    private int id;
    private String name;
    private int electoral_needed;
    private Date createdAt;
    private Date updatedAt;

    public State() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public State(int id) {
        this();
        this.id = id;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getElectoral_needed() {
        return electoral_needed;
    }
    public void setElectoral_needed(int electoral_needed) {
        this.electoral_needed = electoral_needed;
    }

    @Column(name = "created_at", nullable = false, updatable = false)
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at", nullable = false)
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
