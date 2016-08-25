package com.dcsn.controllers;

import com.dcsn.entities.Candidate;
import com.dcsn.enums.Position;
import com.dcsn.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/candidates")
public class CandidateController {
    private CandidateService service;

    @Autowired
    public void setService(CandidateService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Candidate> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/name/{name}"}, method = RequestMethod.GET)
    public Candidate findByName(@PathVariable String name) {
        return this.service.findByName(name);
    }

    @RequestMapping(path = {"/position/{position}"}, method = RequestMethod.GET)
    public List<Candidate> findByName(@PathVariable Position position) {
        return this.service.findByPosition(position);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Candidate show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Candidate create(@RequestBody Candidate candidate) {
        return this.service.create(candidate);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }
}