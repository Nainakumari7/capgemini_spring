package com.example.assignment1_28_02_26;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue
	private Long authorId;
	private String name;
	private String biography;
	
	@ManyToMany(mappedBy="authors")
	private Set<Book> books;
	
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", biography=" + biography + "]";
	}
	
	public Author() {
		
	}

}
