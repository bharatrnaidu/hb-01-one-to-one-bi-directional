package com.bharat.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharat.entity.Instructor;
import com.bharat.entity.InstructorDetail;

public class DeleteDemo {

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
	    
	    // get instructor by primary key / id.
	    int theId = 1;
	    
	    // Note : returns [null] if data not found
	    Instructor tempInstructor = session.get(Instructor.class, theId);
	    
	    System.out.println("Found Instructor: " + tempInstructor);
	    // delete the instructors.
	    if(tempInstructor != null) {
		System.out.println("Deleting: " + tempInstructor);
		
		// Note: will ALSO delete associated Instructor_detail object
		// because of CascadeType.All
		session.delete(tempInstructor);
	    }
	    
	    // commit transaction.
	    session.getTransaction().commit();
	    
	    System.out.println("Done!");

	} 
	finally 
	{
	    factory.close();
	}

    }

}
