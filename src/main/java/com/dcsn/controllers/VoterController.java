package com.dcsn.controllers;


import com.dcsn.entities.Voter;
import com.dcsn.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/voters")
public class VoterController {
    private VoterService service;

    @Autowired
    public void setService(VoterService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Voter> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/name/{name}"}, method = RequestMethod.GET)
    public Voter findByName(@PathVariable String name) {
        return this.service.findByName(name);
    }
//
//    @RequestMapping(path = {"/rating/{rating}"}, method = RequestMethod.GET)
//    public List<Voter> findByName(@PathVariable Rating rating) {
//        return this.service.findByRatingOrderByReleasedDesc(rating);
//    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Voter show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Voter create(@RequestBody Voter voter) {
        return this.service.create(voter);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }
}
