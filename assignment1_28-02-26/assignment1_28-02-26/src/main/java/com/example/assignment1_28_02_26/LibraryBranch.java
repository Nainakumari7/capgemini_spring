package com.example.assignment1_28_02_26;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LibraryBranch {
	
	@Id
	@GeneratedValue
	private Long branchId;
	private String name;
	private String location;
	private String contactNumber;
	
	@OneToMany(mappedBy="branch")
	private List<Book> books;
	
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "LibraryBranch [branchId=" + branchId + ", name=" + name + ", location=" + location + ", contactNumber="
				+ contactNumber + "]";
	}
	
	public LibraryBranch() {
		
	}
	

}
