package com.dcsn.entities;

import com.dcsn.enums.Ethnicity;
import com.dcsn.enums.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="voters")
public class Voter {
    private int id;
    private int version;
    private String name;
    private Ethnicity ethnicity;
    private Gender gender;
    private int age;
    private State state;
    private Date createdAt;
    private Date updatedAt;

    public Voter() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('WHITE', 'BLACK', 'HISPANIC')")
    public Ethnicity getEthnicity() {
        return ethnicity;
    }
    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('M', 'F')")
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "state_id")
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
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
