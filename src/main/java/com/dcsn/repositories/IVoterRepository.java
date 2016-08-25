package com.dcsn.repositories;

import com.dcsn.entities.Voter;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IVoterRepository extends PagingAndSortingRepository<Voter, Integer> {
     public Voter findByName(String name);
//   public List<Voter> findByRatingOrderByReleasedDesc(Rating rating);
}