package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entity.Employee;

public class Launch {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("config");
		EntityManager em = emf.createEntityManager();
		
		// Unlike JDBC that auto commits whenever a query is run, in Hibernate, we need to always begin a transaction and commit it
		// to make changes reflected in the DB
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Employee employee = new Employee(11, "raju", "gsfkshdfkah", 1000);
		em.persist(employee);
		
		transaction.commit();
		System.out.println("Data Inserted");
		
	}

}
