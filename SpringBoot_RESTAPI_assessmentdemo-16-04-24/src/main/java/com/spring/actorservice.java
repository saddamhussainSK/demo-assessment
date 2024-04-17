package com.spring;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class actorservice {
	@Autowired
	private actorrepo ar;
	public Page<actors> getallactors(Pageable p){
		return ar.findAll(p);
		
	}
	public actors addactor(actors ac) {
		return ar.save(ac);
		
	}
	public actors getactorbyid(Long id) {
		Optional<actors> a=ar.findById(id);
		
		return a.get();
		
	}
	public actors updateactor(Long id,actors ac) {
		ac.setId(id);
		return ar.save(ac);
		
	}
	public void deleteactor(Long id) {
		ar.deleteById(id);
	}
}
