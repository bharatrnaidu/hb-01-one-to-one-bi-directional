package com.bharat.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharat.entity.Instructor;
import com.bharat.entity.InstructorDetail;

public class DeleteOnlyInstructorDetail {

	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try 
		{
			// start a transaction.
			session.beginTransaction();

			// get InstructorDetail object.
			int theId = 4;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail.
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// print the associated instructor. 
			System.out.println("tempInstructor: " + tempInstructorDetail.getInstructor());
			
			// now, let's delete the instructor detail
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			
			// Step 2: Remove the assoicated object reference
			// Break bi-directional link between Instructor and InstructorDetail:
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// deleting only InstructorDetail.
			session.delete(tempInstructorDetail);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		} 
		finally 
		{
			// To handle --> ERROR: Connection leak detected: there are 1 unclosed connections!
			session.close();

			factory.close();
		}

	}

}
