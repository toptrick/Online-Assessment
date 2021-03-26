package com.wipro.OnlineAssessment.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.OnlineAssessment.Entity.Users;
public interface UsersRepository extends JpaRepository<Users,String>{

	@Query("from Users order by firstname asc")
	List<Users> findByName();
	
	Users findByEmail(String email);
}
