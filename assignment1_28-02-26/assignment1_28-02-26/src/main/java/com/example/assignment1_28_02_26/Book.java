package com.example.assignment1_28_02_26;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private Long bookId;
	private String title;
	@Column(unique = true)
	private String isbn;
	private int publishYear;
	private int copiesTotal;
	private int copiesAvailable;
	private String status;
	
	
	@ManyToMany
	@JoinTable(
		name = "book_author",
		joinColumns = @JoinColumn(name = "book_id"),
		inverseJoinColumns = @JoinColumn(name = "author_id")
	)
	private Set<Author> authors;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	private LibraryBranch branch;

	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public int getCopiesTotal() {
		return copiesTotal;
	}
	public void setCopiesTotal(int copiesTotal) {
		this.copiesTotal = copiesTotal;
	}
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LibraryBranch getBranch() {
		return branch;
	}
	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", publishYear=" + publishYear
				+ ", copiesTotal=" + copiesTotal + ", copiesAvailable=" + copiesAvailable + ", status=" + status + "]";
	}
	
	public Book() {
		
	}
}
