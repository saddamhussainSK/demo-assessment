package com.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class actorcontroller {
	@Autowired
	private actorservice as;
	
	@GetMapping("/{id}")
	public Page<actors> getallactors(@RequestParam(defaultValue="0")int page,
			@RequestParam(defaultValue="10")int size,
			@RequestParam(defaultValue="asc")String direction){
Sort.Direction d=Sort.Direction.fromString(direction);
Pageable p=PageRequest.of(page, size,Sort.by(d,direction));
return as.getallactors(p);
	}
	@PostMapping
	public actors addactor(@RequestBody actors ac) {
		return as.addactor(ac);
		
	}
	@GetMapping("/{id}")
	public actors getactorbyid(Long id) {
		actors a=as.getactorbyid(id);
		return a;
		
	}
	@PutMapping("/{id}")
	public actors updateactor(Long id,actors ac) {
		ac.setId(id);
		return as.updateactor(id, ac);
		
	}
	@DeleteMapping("/{id}")
	public void deleteactor(Long id) {
		as.deleteactor(id);
	}  
}
