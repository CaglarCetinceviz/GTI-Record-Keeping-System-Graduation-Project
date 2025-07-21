package com.caglar.finalprojectaws.Controllers;

public class Course {
    
    private String course_id;
    private String course_name;
    private String class_code;

    
    // constructors
    public Course() {
        // Default constructor
    }

    // Full constructors
    public Course(String course_id, String course_name, String class_code) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.class_code = class_code;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }
    
    
}
