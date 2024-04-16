package com.spring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class film {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private int year;
	@ManyToOne
	@JoinColumn(name="actor_id")
	private actors actor;
	public film() {
		
	}
	public film(String title,int year) {
		this.title=title;
		this.year=year;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public actors getActor() {
		return actor;
	}
	public void setActor(actors actor) {
		this.actor = actor;
	}
	
	
}

