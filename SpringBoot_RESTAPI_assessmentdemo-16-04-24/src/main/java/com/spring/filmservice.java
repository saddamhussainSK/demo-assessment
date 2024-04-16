package com.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class filmservice {
	@Autowired
	private filmrepo fr;
	public Page<film> getallfilms(Pageable p){
		return fr.findAll(p);
		
	}
	public film addfilm(film f) {
		return fr.save(f);
		
	}
	public film getfilmbyid(Long id) {
		Optional<film> a=fr.findById(id);
		
		return a.get();
		
	}
	public film updatefilm(Long id,film f) {
		f.setId(id);
		return fr.save(f);
		
		
	}
	public void deletefilm(Long id) {
		fr.deleteById(id);
	}
}
