package com.bharat.entity;

import javax.persistence.*;

// annotate the class as an entity and map to db table.
@Entity
@Table(name="instructor_detail")
public class InstructorDetail 
{
    // define the fields.
    // annotate the fields with db columns names.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="youtube_channel")
    private String youtubeChannel;
    
    @Column(name="hobby")
    private String hobby;
    
    // Step 1.1: New field to refer Instructor:
    // Step 1.3: Add @OneToOne annotation:
    // Note: Below code refers to "instructorDetail" property in "Instructor" class
    // 		 And all type of cascading is supported..
    /* 
     	@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
		private Instructor instructor;
    */
    
    // In Below annotation cascade delete will not work other cascades will work.
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    // create constructors.
    public InstructorDetail(String youtubeChannel, String hobby) {
	super();
	this.youtubeChannel = youtubeChannel;
	this.hobby = hobby;
    }
    public InstructorDetail() {

    }
    
    // generate getter/setter methods.
    // Step 1.2: Add getter and setter for Instructor:
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    // generate toString() method.
    @Override
    public String toString() 
    {
	return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
    }
}
