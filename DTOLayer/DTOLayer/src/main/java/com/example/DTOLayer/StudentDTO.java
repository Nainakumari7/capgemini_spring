package com.example.DTOLayer;

public class StudentDTO {

    private String name;
    private String college;
    private double marks;
    private String gender;
    private String email;
    private String phone;
    

    public String getName() {
        return name;
    }
    public void setName(String name) {   // fixed
        this.name = name;
    }

    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }

    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    
}