package com.bharat.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharat.entity.Instructor;
import com.bharat.entity.InstructorDetail;
import com.bharat.entity.Student;

public class InstructorDemoApp {

    public static void main(String[] args)
    {
	SessionFactory factory = new Configuration()
                                    		.configure("hibernate.cfg.xml")
                                    		.addAnnotatedClass(Instructor.class)
                                    		.addAnnotatedClass(InstructorDetail.class)
                                    		.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	try 
	{
	    // Create the objects.
	    Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
	    
	    InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.madhuplayer.com/youtube", "Guitar");
	    
	    // associate the objects.
	    tempInstructor.setInstructorDetail(tempInstructorDetail);
	    
	    // start a transaction.
	    session.beginTransaction();
		
	    // save instructor.
	    /*
	     * Note: It will also save InstructorDetail (details object)
	     * 		because of CascadeType.All
	     */
	    System.out.println("Saving Instructor: " + tempInstructor);
	    session.save(tempInstructor);
		
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
