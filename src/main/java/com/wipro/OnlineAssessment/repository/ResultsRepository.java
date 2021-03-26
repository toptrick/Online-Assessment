package com.wipro.OnlineAssessment.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.OnlineAssessment.Entity.Results;
public interface ResultsRepository extends JpaRepository<Results,String> {
	@Query("from Results order by TestDate asc")
	List<Results> findByTestDate();
}
