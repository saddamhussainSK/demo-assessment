package com.spring;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface actorrepo extends JpaRepository<actors,Long>{

	
}
