package com.caglar.finalprojectaws.Controllers;

public class Subject {
    
    private String subject_id;
    private String course_id;
    private String teacher_id;
    private String subject_name;
    
    
    // Constructors
    public Subject(){
        //default Constructors
    }

    
    public Subject(String subject_id, String course_id, String teacher_id, String subject_name) {
        this.subject_id = subject_id;
        this.course_id = course_id;
        this.teacher_id = teacher_id;
        this.subject_name = subject_name;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
    
    
    
}
