package com.caglar.finalprojectaws.Controllers;

public class Teacher extends Person {

    private String teacher_id;
    private String password;
    private String full_name;
    private String subject_id;
    private String course_id;

    // Constructors
    public Teacher() {
        // Default constructor
    }

    // Constructor only for teacher_id
    public Teacher(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    // Consturctor for Teacher Info
    public Teacher(String teacher_id, String first_name, String sur_name, String password, String PPSN, String gender, String email,
            String phone_number, String address_line_one, String address_line_two, String city, String eircode, String date_of_birth) {
        super(first_name, sur_name, PPSN, gender, email, phone_number, address_line_one, address_line_two, city, eircode, date_of_birth);
        this.teacher_id = teacher_id;
        this.password = password;
    }

    // Constructor for adding new teacher At New Teacher Frame
    public Teacher(String first_name, String sur_name, String password, String PPSN, String gender, String email, String phone_number,
            String address_line_one, String address_line_two, String city, String eircode, String date_of_birth) {
        super(first_name, sur_name, PPSN, gender, email, phone_number, address_line_one, address_line_two, city, eircode, date_of_birth);
        this.password = password;
    }

    // Getter and Setters
    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public void displayInfo() {
        System.out.println("Teacher info: " + getFirst_name() + " " + getSur_name());
    }
}
