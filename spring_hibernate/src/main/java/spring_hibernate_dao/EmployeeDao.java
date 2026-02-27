package spring_hibernate_dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_hibernate_dto.Employee;



@Repository
public class EmployeeDao {
	
	@Autowired
	EntityManager entityManager;
	
	public void insert(Employee e) {
		entityManager.getTransaction().begin();
		
		Employee employee = findById(e.getId());
		if(employee==null) {
			entityManager.persist(e);
		}else {
			System.out.println("Data exist");
		}
		
		entityManager.getTransaction().commit();
	}
	
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

}
