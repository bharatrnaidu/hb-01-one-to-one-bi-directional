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

    // create constructors.
    public InstructorDetail(String youtubeChannel, String hobby) {
	super();
	this.youtubeChannel = youtubeChannel;
	this.hobby = hobby;
    }
    public InstructorDetail() {

    }
    
    // generate getter/setter methods.
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
