package com.bharat.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharat.entity.Instructor;
import com.bharat.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try 
		{
			// start a transaction.
			session.beginTransaction();
			
			// Step 2: below three comments:
			// get InstructorDetail object.
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail.
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			// print the associated instructor. 
			System.out.println("tempInstructor: " + tempInstructorDetail.getInstructor());

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
