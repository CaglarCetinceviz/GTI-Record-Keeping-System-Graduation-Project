package com.caglar.finalprojectaws.Controllers;

public class Student extends Person {

    private String student_id;
    private String class_code;
    private double first_grade;
    private double second_grade;
    private double third_grade;
    private double final_exam;
    private double over_all;
    private String subject_id;

    // Constructors
    public Student() {
        // Default constructors
    }

    // Constructor only for student_id
    public Student(String student_id) {
        this.student_id = student_id;
    }

    // Constructor for student_id, first_grade, second_grade, third_grade, final_exam, and overall
    public Student(String student_id, String subject_id, double first_grade, double second_grade, double third_grade, double final_exam) {
        this.student_id = student_id;
        this.subject_id = subject_id;
        this.first_grade = first_grade;
        this.second_grade = second_grade;
        this.third_grade = third_grade;
        this.final_exam = final_exam;;
    }

    // Consturctor for student table    
    public Student(String student_id, String class_code, String first_name, String sur_name, String PPSN, String gender, String email, String phone_number, String address_line_one, String address_line_two, String city, String eircode, String date_of_birth) {
        super(first_name, sur_name, PPSN, gender, email, phone_number, address_line_one, address_line_two, city, eircode, date_of_birth);
        this.student_id = student_id;
        this.class_code = class_code;
    }

    // Constructor for adding new student
    public Student(String class_code, String first_name, String sur_name, String PPSN, String gender, String email, String phone_number, String address_line_one, String address_line_two, String city, String eircode, String date_of_birth) {
        super(first_name, sur_name, PPSN, gender, email, phone_number, address_line_one, address_line_two, city, eircode, date_of_birth);
        this.class_code = class_code;
    }

    // Constructor for all properties
    public Student(String student_id, String class_code, String first_name, String sur_name, String PPSN,
            String gender, String email, String phone_number, String address_line_one, String address_line_two,
            String city, String eircode, String date_of_birth, double first_grade, double second_grade, double third_grade, double final_exam, double over_all) {
        super(first_name, sur_name, PPSN, gender, email, phone_number, address_line_one, address_line_two, city, eircode, date_of_birth);
        this.student_id = student_id;
        this.class_code = class_code;
        this.first_grade = first_grade;
        this.second_grade = second_grade;
        this.third_grade = third_grade;
        this.final_exam = final_exam;
        this.over_all = over_all;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public double getFirst_grade() {
        return first_grade;
    }

    public void setFirst_grade(double first_grade) {
        this.first_grade = first_grade;
    }

    public double getSecond_grade() {
        return second_grade;
    }

    public void setSecond_grade(double second_grade) {
        this.second_grade = second_grade;
    }

    public double getThird_grade() {
        return third_grade;
    }

    public void setThird_grade(double third_grade) {
        this.third_grade = third_grade;
    }

    public double getFinal_exam() {
        return final_exam;
    }

    public void setFinal_exam(double final_exam) {
        this.final_exam = final_exam;
    }

    public double getOver_all() {
        return over_all;
    }

    public void setOver_all(double over_all) {
        this.over_all = over_all;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student info: " + getFirst_name() + " " + getSur_name());
    }

}
