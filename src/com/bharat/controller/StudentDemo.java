package com.bharat.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bharat.entity.*;

public class StudentDemo {

	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try 
		{
			// create a Student object
			System.out.println("Creating new Student object...");
			Student tempStudent = new Student("Paul", "Wall", "paul@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the Student object
			System.out.println("Saving the Student object");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally 
		{
			factory.close();
		}
	}
}
