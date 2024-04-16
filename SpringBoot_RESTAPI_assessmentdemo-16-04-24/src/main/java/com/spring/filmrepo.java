package com.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface filmrepo extends JpaRepository<film,Long>{

}
