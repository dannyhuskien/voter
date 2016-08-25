package com.dcsn.repositories;

import com.dcsn.entities.Candidate;
import com.dcsn.enums.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICandidateRepository extends PagingAndSortingRepository<Candidate, Integer> {
     public Candidate findByName(String name);
     public List<Candidate> findByPosition(Position position);
     // @Query("select distinct c from Candidate c join c.voter v where v.id = :id")
     // public Page<Candidate> findAllCandidateByPosition(@Param("position") Position position, Pageable pageable);
     // public List<Candidate> findByPosition(Position position);
}