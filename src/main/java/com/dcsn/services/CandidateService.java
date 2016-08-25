package com.dcsn.services;

import com.dcsn.enums.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.dcsn.entities.Candidate;
import com.dcsn.repositories.ICandidateRepository;


import java.util.List;

@Service
public class CandidateService {

    private ICandidateRepository repository;

    @Autowired
    public void setRepository(ICandidateRepository repository) {
        this.repository = repository;
    }

    public Page<Candidate> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Candidate findByName(String name) {
        return this.repository.findByName(name);
    }

    public List<Candidate> findByPosition(Position position) {
        return this.repository.findByPosition(position);
    }

    public Candidate findOne(int id) {
        return this.repository.findOne(id);
    }

    public Candidate create(Candidate c) {
        return this.repository.save(c);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }
}

