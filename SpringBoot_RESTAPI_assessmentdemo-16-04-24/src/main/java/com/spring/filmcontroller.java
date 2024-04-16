package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("films")
public class filmcontroller {
	@Autowired
	private filmservice fs;
	@GetMapping("/{id}")
	public Page<film> getallfilms(@RequestParam(defaultValue="0")int page,
									@RequestParam(defaultValue="10")int size,
									@RequestParam(defaultValue="asc")String direction){
		Sort.Direction d=Sort.Direction.fromString(direction);
	Pageable p=PageRequest.of(page, size,Sort.by(d,direction));
						return fs.getallfilms(p);
							}
	@PostMapping
	public film addfilm(@RequestBody film f) {
		return fs.addfilm(f);
	}
	@GetMapping("/{id}")
	public film getfilmbyid(@PathVariable Long id) {
		return fs.getfilmbyid(id);
	}
	@DeleteMapping("/{id}")
	public film updatefilm(@PathVariable Long id,@RequestBody film f) {
		return fs.updatefilm(id, f);
	}
	@DeleteMapping("/{id}")
	public void deletefilm(@PathVariable Long id) {
		fs.deletefilm(id);
	}
}
