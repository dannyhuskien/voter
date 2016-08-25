package com.dcsn.services;

import com.dcsn.entities.Voter;
import com.dcsn.repositories.IVoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    private IVoterRepository repository;

    @Autowired
    public void setRepository(IVoterRepository repository) {
        this.repository = repository;
    }

    public Page<Voter> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Voter findByName(String name) {
        return this.repository.findByName(name);
    }
//
//    public List<Voter> findByRatingOrderByReleasedDesc(Rating rating) {
//        return this.repository.findByRatingOrderByReleasedDesc(rating);
//    }

    public Voter findOne(int id) {
        return this.repository.findOne(id);
    }

    public Voter create(Voter v) {
        return this.repository.save(v);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }
}
