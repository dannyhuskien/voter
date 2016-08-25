package com.dcsn.entities;

import com.dcsn.enums.Party;
import com.dcsn.enums.Position;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "candidates")
public class Candidate {
    private int id;
    private int version;
    private String name;
    private Position position;
    private Party party;
    private Date createdAt;
    private Date updatedAt;
    private List<Voter> voters;

    public Candidate() {
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
    @Column(columnDefinition = "ENUM('PRESIDENT', 'GOVERNOR', 'SENATOR')")
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DEMOCRAT', 'REPUBLICAN')")
    public Party getParty() {
        return party;
    }
    public void setParty(Party party) {
        this.party = party;
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


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "voters_candidates",
            joinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"))
    public List<Voter> getVoters() {return voters;}
    public void setVoters(List<Voter> voters) {this.voters = voters;}



    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
