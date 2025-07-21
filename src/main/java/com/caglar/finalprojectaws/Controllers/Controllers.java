package com.caglar.finalprojectaws.Controllers;

import static com.caglar.finalprojectaws.ValidationAndMethod.ValidationAndCalculation.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.caglar.finalprojectaws.Controllers.Course;

public class Controllers {

    private Connection con = null;

    private Statement st = null;

    private PreparedStatement prest = null;

    // Constructor
    public Controllers() {
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.databaseName;
        try {
            con = DriverManager.getConnection(url, Database.userName, Database.password);
            System.out.println("connected");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Admin Login Method at Login Frame
    public boolean loginAdmin(String email, String password) {

        String sql = "SELECT * FROM admin WHERE email = ? and password = ?";

        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, email);
            prest.setString(2, password);

            ResultSet rs = prest.executeQuery();

            // This is short version of if (rs.next() == false) { return false; } else { return true;}
            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Admin Login Method at Login Frame
    public boolean loginTeacher(String email, String password) {

        String sql = "SELECT * FROM teacher WHERE email = ? and password = ?";

        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, email);
            prest.setString(2, password);

            ResultSet rs = prest.executeQuery();

            // This is short version of if (rs.next() == false) { return false; } else { return true;}
            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Fetch the Subjects at Teacher Frame
    public void selectSubject(JComboBox cb) {

        Subject sub = new Subject();

        String sql = "Select * FROM subject";

        try {
            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            cb.removeAllItems();

            while (rs.next()) {

                sub.setSubject_id(rs.getString(1));
                sub.setCourse_id(rs.getString(2));
                sub.setTeacher_id(rs.getInt(3)+"");
                sub.setSubject_name(rs.getString(4));

                cb.addItem(sub.getSubject_id() + "   " + sub.getSubject_name());
            }
//            con.close();
            rs.close();
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Student Search by ID at Teacher Frame
    public void searchStudent(JTextField studentIDTF, JTextField fullnameTF) {
        try {

            Student s1 = new Student(studentIDTF.getText());
            String sql = "SELECT * FROM student WHERE student_id = ?";

            prest = con.prepareStatement(sql);
            prest.setString(1, s1.getStudent_id());

            ResultSet rs = prest.executeQuery();
            String fullname = "";

            if (!rs.next()) {
                DisplayMessage("Student Not Found!!!");
                return;
            } else {
                do {
                    s1.setFirst_name(rs.getString(4));
                    s1.setSur_name(rs.getString(5));
                    fullname = s1.getFirst_name() + " " + s1.getSur_name();
                } while (rs.next());
            }
            prest.close();
            rs.close();
            fullnameTF.setText(fullname.toUpperCase());
        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // setting all grade sql queries by Studend id and subject id at Teacher Frame
    public void searchGrades(String GetSubject_id, JTextField studentIDTF, JTextField gradeOneTF, JTextField gradeTwoTF, JTextField gradeThreeTF,
            JTextField finalExamTF, JTextField resultTF) {

        Student s1 = new Student(studentIDTF.getText());

        try {

            String sql = "SELECT grade.first_grade,grade.second_grade, third_grade, final_exam, over_all FROM grade\n"
                    + "INNER JOIN student ON grade.student_id = student.student_id\n"
                    + "INNER JOIN subject ON grade.subject_id = subject.subject_id\n"
                    + "WHERE grade.student_id = ? and grade.subject_id = ? ";

            // Fetching All grades and Overall Result
            prest = con.prepareStatement(sql);
            prest.setString(1, s1.getStudent_id());
            prest.setString(2, GetSubject_id);
            ResultSet rs = prest.executeQuery();

            if (!rs.next()) {
                DisplayMessage("Grade not Found!!!");
                return;
            } else {
                do {
                    s1.setFirst_grade(rs.getDouble(1));
                    s1.setSecond_grade(rs.getDouble(2));
                    s1.setThird_grade(rs.getDouble(3));
                    s1.setFinal_exam(rs.getDouble(4));
                    s1.setOver_all(rs.getDouble(5));
                    gradeOneTF.setText(s1.getFirst_grade() + "");
                    gradeTwoTF.setText(s1.getSecond_grade() + "");
                    gradeThreeTF.setText(s1.getThird_grade() + "");
                    finalExamTF.setText(s1.getFinal_exam() + "");
                    if (s1.getOver_all() >= 80) {
                        resultTF.setText("A Distinction");
                    } else if (s1.getOver_all() >= 50 && s1.getOver_all() <= 80) {
                        resultTF.setText("B not bad");
                    } else {
                        resultTF.setText("You are failed!");
                    }
                } while (rs.next());
            }
            prest.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Update student grades by student id and subject id at Teacher Frame
    public void updateGrades(JTextField studentID, String subject_id, JTextField gradeOne, JTextField gradeTwo, JTextField gradeThree, JTextField finalExam) {

        Student s1 = new Student(studentID.getText().toString(), subject_id, ValidateDouble(gradeOne.getText()),
                ValidateDouble(gradeTwo.getText()), ValidateDouble(gradeThree.getText()), ValidateDouble(finalExam.getText()));

        String sql = "UPDATE grade\n"
                + "JOIN student s ON grade.student_id = s.student_id\n"
                + "JOIN subject sub ON grade.subject_id = sub.subject_id\n"
                + "SET grade.first_grade = ?, grade.second_grade = ?, grade.third_grade = ?, grade.final_exam = ?\n"
                + "WHERE grade.student_id = ? AND grade.subject_id = ?";
        try {

            System.out.println(s1.getStudent_id() + " " + s1.getSubject_id() + " " + s1.getFirst_grade() + " "
                    + s1.getSecond_grade() + " " + s1.getThird_grade() + " " + s1.getFinal_exam());

            prest = con.prepareStatement(sql);

            prest.setDouble(1, s1.getFirst_grade());
            prest.setDouble(2, s1.getSecond_grade());
            prest.setDouble(3, s1.getThird_grade());
            prest.setDouble(4, s1.getFinal_exam());
            prest.setString(5, s1.getStudent_id());
            prest.setString(6, s1.getSubject_id());

            prest.executeUpdate();

            DisplayMessage("Grade Succesfully Updated");
            prest.close();
        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        }
    }

    // Set the student grades to NULL by student id and subject id at Teacher Frame
    public void deleteGrades(JTextField studentID, String subject_id, JTextField gradeOne, JTextField gradeTwo, JTextField gradeThree, JTextField finalExam) {

        Student s1 = new Student(studentID.getText().toString(), subject_id, ValidateDouble(gradeOne.getText()),
                ValidateDouble(gradeTwo.getText()), ValidateDouble(gradeThree.getText()), ValidateDouble(finalExam.getText()));

        String sql = "UPDATE grade\n"
                + "JOIN student s ON grade.student_id = s.student_id\n"
                + "JOIN subject sub ON grade.subject_id = sub.subject_id\n"
                + "SET grade.first_grade = NULL, grade.second_grade = NULL, grade.third_grade = NULL, grade.final_exam = NULL\n"
                + "WHERE grade.student_id = ? AND grade.subject_id = ?";

        try {

            System.out.println(s1.getStudent_id() + " " + s1.getSubject_id() + " " + s1.getFirst_grade() + " "
                    + s1.getSecond_grade() + " " + s1.getThird_grade() + " " + s1.getFinal_exam());

            prest = con.prepareStatement(sql);

            prest.setString(1, s1.getStudent_id());
            prest.setString(2, s1.getSubject_id());

//            prest.executeUpdate();
            int del = prest.executeUpdate();

            if (del > 0) {
                DisplayMessage("✅ All grade deleted successfully!");
            } else {
                DisplayMessage("⚠ No record found for this student and subject.");
            }

//            DisplayMessage("Grade Succesfully Deleted");
            prest.close();
        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        }
    }

    // Fetching the all courses at TeacherClassGroupFrame
    public void selectCourses(JComboBox cb) {

        Course c1 = new Course();
        String sql = "Select * FROM course";

        try {
            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                c1.setCourse_id(rs.getString(1));
                c1.setCourse_name(rs.getString(2));

//                courseCB.addItem(c1.getCourse_id() + "   " + c1.getCourse_name());
                cb.insertItemAt((c1.getCourse_id() + "   " + c1.getCourse_name()), 0);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Fetch the Class Groups at TeacherClassGroupFrame
    public void selectClassGroup(JComboBox cb, String courseId) {

        Course c1 = new Course();

        String sql = "SELECT class_group.class_code FROM class_group\n"
                + "INNER JOIN course ON class_group.course_id = course.course_id\n"
                + "WHERE class_group.course_id = ? ";

        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, courseId);
            ResultSet rs = prest.executeQuery();
            cb.removeAllItems();
            while (rs.next()) {
                c1.setClass_code(rs.getString(1));

                cb.addItem(c1.getClass_code());
            }

//            con.close();
            rs.close();
            prest.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Fetch the Subjects by course id at TeacherClassGroupFrame
    public void selectSubjectByCourse(JComboBox cb, String courseId) {

        Subject s1 = new Subject();

        String sql = "SELECT * FROM subject\n"
                + "INNER JOIN course ON subject.course_id = course.course_id\n"
                + "WHERE subject.course_id =  ? ";

        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, courseId);
            ResultSet rs = prest.executeQuery();

            cb.removeAllItems();

            while (rs.next()) {
                s1.setSubject_id(rs.getString(1));
                s1.setSubject_name(rs.getString(4));

                cb.addItem(s1.getSubject_id() + " " + s1.getSubject_name());
            }

            rs.close();
            prest.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Search Student and Their Grades by Class Code and Subject ID at TeacherClassGroupFrame
    public void mainTableSearch(String classCode, String subjectID, String subjectFull, DefaultTableModel tableModel1) {

        Course c1 = new Course();
        Subject sub1 = new Subject();
        Student s1 = new Student();

        String sql = "SELECT class_group.course_id, student.class_code, grade.subject_id,student.student_id,\n"
                + " student.first_name, student.sur_name, grade.first_grade, grade.second_grade, third_grade, final_exam, over_all\n"
                + "FROM student\n"
                + "INNER JOIN class_group ON student.class_code = class_group.class_code\n"
                + "INNER JOIN grade ON student.student_id = grade.student_id\n"
                + "WHERE student.class_code = ? and grade.subject_id = ?";

        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, classCode);
            prest.setString(2, subjectID);
            ResultSet rs = prest.executeQuery();
            if (!rs.next()) {
                DisplayMessage("Student Not Found!!!");
            } else {
                do {
                    Vector row = new Vector();
                    c1.setCourse_id(rs.getString(1));
                    c1.setClass_code(rs.getString(2));
                    sub1.setSubject_id(subjectFull);
                    s1.setStudent_id(rs.getInt(4)+"");
                    s1.setFirst_name(rs.getString(5));
                    s1.setSur_name(rs.getString(6));
                    s1.setFirst_grade(rs.getDouble(7));
                    s1.setSecond_grade(rs.getDouble(8));
                    s1.setThird_grade(rs.getDouble(9));
                    s1.setFinal_exam(rs.getDouble(10));
                    s1.setOver_all(rs.getDouble(11));

                    row.add(c1.getCourse_id());
                    row.add(c1.getClass_code());
                    row.add(sub1.getSubject_id());
                    row.add(s1.getStudent_id());
                    row.add(s1.getFirst_name().toUpperCase() + " " + s1.getSur_name().toUpperCase());
                    row.add(s1.getFirst_grade());
                    row.add(s1.getSecond_grade());
                    row.add(s1.getThird_grade());
                    row.add(s1.getFinal_exam());
                    row.add(s1.getOver_all());
                    tableModel1.addRow(row);
                } while (rs.next());
            }
            prest.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Add/Update Grade by student id and subject id at TeacherClassGroupFrame
    public void addUpdate(String studentId, String subjectId, Double firstGrade, Double secondGrade, Double thirdGrade, Double finalExam) {

        Student s1 = new Student(studentId, subjectId, ValidateDouble(firstGrade + ""), ValidateDouble(secondGrade + ""),
                ValidateDouble(thirdGrade + ""), ValidateDouble(finalExam + ""));

        String sql = "UPDATE grade\n"
                + "JOIN student s ON grade.student_id = s.student_id\n"
                + "JOIN subject sub ON grade.subject_id = sub.subject_id\n"
                + "SET grade.first_grade = ?, grade.second_grade = ?, grade.third_grade = ?, grade.final_exam = ?\n"
                + "WHERE grade.student_id = ? AND grade.subject_id = ?";

        try {

            prest = con.prepareStatement(sql);

            prest.setDouble(1, s1.getFirst_grade());
            prest.setDouble(2, s1.getSecond_grade());
            prest.setDouble(3, s1.getThird_grade());
            prest.setDouble(4, s1.getFinal_exam());
            prest.setString(5, s1.getStudent_id());
            prest.setString(6, s1.getSubject_id());

            prest.executeUpdate();

            DisplayMessage("Grade Succesfully Updated");

            prest.close();
        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        }
    }

    // Set Grades to null by student id and subject id at TeacherClassGroupFrame
    public void delete(String studentId, String subjectId, Double firstGrade, Double secondGrade, Double thirdGrade, Double finalExam) {

        Student s1 = new Student(studentId, subjectId, ValidateDouble(firstGrade + ""), ValidateDouble(secondGrade + ""),
                ValidateDouble(thirdGrade + ""), ValidateDouble(finalExam + ""));

        String sql = "UPDATE grade\n"
                + "JOIN student s ON grade.student_id = s.student_id\n"
                + "JOIN subject sub ON grade.subject_id = sub.subject_id\n"
                + "SET grade.first_grade = NULL, grade.second_grade = NULL, grade.third_grade = NULL, grade.final_exam = NULL\n"
                + "WHERE grade.student_id = ? AND grade.subject_id = ?";

        try {
            prest = con.prepareStatement(sql);

            prest.setString(1, s1.getStudent_id());
            prest.setString(2, s1.getSubject_id());

//            prest.executeUpdate();
            int del = prest.executeUpdate();

            if (del > 0) {
                DisplayMessage("✅ All grade deleted successfully!");
            } else {
                DisplayMessage("⚠ No record found for this student and subject.");
            }

//            DisplayMessage("Grade Succesfully Deleted");
            prest.close();
        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        }
    }

    // Update Student Details at TeacherClassGroupFrame
    public void updateStudentDetail(JTextField studentIdTF, JTextField classCodeTF, JTextField firstNameTF, JTextField surnameTF,
            JTextField ppsnTF, JTextField genderTF, JTextField emailTF, JTextField phoneNumberTF, JTextField addressLineOneTF, JTextField addressLineTwoTF,
            JTextField cityTF, JTextField eircodeTF, JTextField dobTF) {

        Student s1 = new Student(studentIdTF.getText().toString(), classCodeTF.getText().toString(), firstNameTF.getText().toString(), surnameTF.getText().toString(),
                ppsnTF.getText().toString(), genderTF.getText().toString(), emailTF.getText().toString(), phoneNumberTF.getText().toString(), addressLineOneTF.getText().toString(),
                addressLineTwoTF.getText().toString(), cityTF.getText().toString(),
                eircodeTF.getText().toString(), dobTF.getText().toString());

        String sql = "UPDATE student\n"
                + "SET class_code = ?, first_name = ?, sur_name = ?, PPSN = ?, gender = ?, email = ?, phone_number = ?,\n"
                + "address_line_one = ?, address_line_two = ?, city = ?, eircode = ?, date_of_birth = ?\n"
                + "WHERE student_id = ?";

        try {
            prest = con.prepareStatement(sql);

            prest.setString(1, s1.getClass_code());
            prest.setString(2, s1.getFirst_name());
            prest.setString(3, s1.getSur_name());
            prest.setString(4, s1.getPPSN());
            prest.setString(5, s1.getGender());
            prest.setString(6, s1.getEmail());
            prest.setString(7, s1.getPhone_number());
            prest.setString(8, s1.getAddress_line_one());
            prest.setString(9, s1.getAddress_line_two());
            prest.setString(10, s1.getCity());
            prest.setString(11, s1.getEircode());
            prest.setString(12, s1.getDate_of_birth());
            prest.setString(13, s1.getStudent_id());

            prest.executeUpdate();

            DisplayMessage("✅ Student Details Succesfully Updated");

//                prest.close();
        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        }
    }

    // Fetching Teacher by id at TeacherInfoFrame
    public void searchTeacher(JTextField teacherIdTF, JTextField firstNameTF, JTextField surnameTF, JPasswordField passwordField,
            JTextField ppsnTF, JTextField genderTF, JTextField dobTF, JTextField emailTF, JTextField phoneNumberTF,
            JTextField addressLineOneTF, JTextField addressLineTwoTF, JTextField cityTF, JTextField eircodeTF) {

        Teacher t1 = new Teacher(teacherIdTF.getText());

        // Fetching Teacher Info by teacher_id
        try {
            String sql = "SELECT * FROM teacher WHERE teacher_id = ?";

            prest = con.prepareStatement(sql);
            prest.setString(1, t1.getTeacher_id());

            ResultSet rs = prest.executeQuery();

            if (!rs.next()) {
                DisplayMessage("Teacher Not Found!!!");
                return;
            } else {
                do {
                    t1.setFirst_name(rs.getString(3));
                    t1.setSur_name(rs.getString(4));
                    t1.setPassword(rs.getString(5));
                    t1.setPPSN(rs.getString(6));
                    t1.setGender(rs.getString(7));
                    t1.setEmail(rs.getString(8));
                    t1.setPhone_number(rs.getString(9));
                    t1.setAddress_line_one(rs.getString(10));
                    t1.setAddress_line_two(rs.getString(11));
                    t1.setCity(rs.getString(12));
                    t1.setEircode(rs.getString(13));
                    t1.setDate_of_birth(rs.getString(14));
                } while (rs.next());
            }
            prest.close();
            rs.close();

            firstNameTF.setText(t1.getFirst_name().toUpperCase());
            surnameTF.setText(t1.getSur_name().toUpperCase());
            passwordField.setText(t1.getPassword());
            ppsnTF.setText(t1.getPPSN().toUpperCase());
            genderTF.setText(t1.getGender().toUpperCase());
            dobTF.setText(t1.getDate_of_birth().toUpperCase());
            emailTF.setText(t1.getEmail());
            phoneNumberTF.setText(t1.getPhone_number().toUpperCase());
            addressLineOneTF.setText(t1.getAddress_line_one().toUpperCase());
            addressLineTwoTF.setText(t1.getAddress_line_two().toUpperCase());
            cityTF.setText(t1.getCity().toUpperCase());
            eircodeTF.setText(t1.getEircode().toUpperCase());
        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Update Teacher Details at Teacher Info Frame
    public void updateTeacherDetail(JTextField teacherIdTF, JTextField firstNameTF, JTextField surnameTF, JPasswordField passwordField,
            JTextField ppsnTF, JTextField genderTF, JTextField dobTF, JTextField emailTF, JTextField phoneNumberTF,
            JTextField addressLineOneTF, JTextField addressLineTwo, JTextField cityTF, JTextField eircodeTF){
        
               Teacher t1 = new Teacher(teacherIdTF.getText().toString(), firstNameTF.getText().toString(), surnameTF.getText().toString(),
                passwordField.getPassword().toString(), ppsnTF.getText().toString(), genderTF.getText().toString(), emailTF.getText().toString(),
                phoneNumberTF.getText().toString(), addressLineOneTF.getText().toString(), addressLineTwo.getText().toString(), cityTF.getText().toString(),
                eircodeTF.getText().toString(), dobTF.getText().toString());

        
        String sql = "UPDATE teacher\n"
                + "SET first_name = ?, sur_name = ?, password = ?, PPSN = ?, gender = ?, email = ?, phone_number = ?,\n"
                + "address_line_one = ?, address_line_two = ?, city = ?, eircode = ?, date_of_birth = ?\n"
                + "WHERE teacher_id = ?";

        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, t1.getFirst_name());
            prest.setString(2, t1.getSur_name());
            prest.setString(3, t1.getPassword());
            prest.setString(4, t1.getPPSN());
            prest.setString(5, t1.getGender());
            prest.setString(6, t1.getEmail());
            prest.setString(7, t1.getPhone_number());
            prest.setString(8, t1.getAddress_line_one());
            prest.setString(9, t1.getAddress_line_two());
            prest.setString(10, t1.getCity());
            prest.setString(11, t1.getEircode());
            prest.setString(12, t1.getDate_of_birth());
            prest.setString(13, t1.getTeacher_id());

            prest.executeUpdate();

            DisplayMessage("✅ Teacher Details Succesfully Updated");

//            prest.close();
        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        } 
    }
    
    // Add New Student at New Student Frame
    public void addNewStudent(String adminId, JTextField classCodeTF, JTextField firstNameTF, JTextField surnameTF,
            JTextField ppsnTF, JTextField genderTF, JTextField emailTF, JTextField phoneNumberTF,
            JTextField addressLineOneTF, JTextField addressLineTwoTF, JTextField cityTF,
            JTextField eircodeTF, JTextField dobTF) {

        Student s1 = new Student(classCodeTF.getText().toString(), firstNameTF.getText().toString(), surnameTF.getText().toString(),
                ppsnTF.getText().toString(), genderTF.getText().toString(), emailTF.getText().toString(), phoneNumberTF.getText().toString(),
                addressLineOneTF.getText().toString(), addressLineTwoTF.getText().toString(), cityTF.getText().toString(),
                eircodeTF.getText().toString(), dobTF.getText().toString());

        String sql = "INSERT INTO student (admin_id, class_code, first_name, sur_name, PPSN, gender, email,\n"
                + "phone_number, address_line_one, address_line_two, city, eircode, date_of_birth)\n"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            prest = con.prepareStatement(sql);

            prest.setString(1, adminId);
            prest.setString(2, s1.getClass_code());
            prest.setString(3, s1.getFirst_name());
            prest.setString(4, s1.getSur_name());
            prest.setString(5, s1.getPPSN());
            prest.setString(6, s1.getGender());
            prest.setString(7, s1.getEmail());
            prest.setString(8, s1.getPhone_number());
            prest.setString(9, s1.getAddress_line_one());
            prest.setString(10, s1.getAddress_line_two());
            prest.setString(11, s1.getCity());
            prest.setString(12, s1.getEircode());
            prest.setString(13, s1.getDate_of_birth());

            prest.executeUpdate();

            DisplayMessage("✅ New Student Succesfully Added");


        } catch (SQLException e) {
            DisplayMessage("❌ New Student Adding Failed\n Make sure all the fields are filled");
            System.err.println("❌ Database error: " + e.getMessage());
        }
    }
    
    // Add New Teacher at New Teacher Frame
    public void addNewTeacher(String adminId, JTextField firstNameTF, JTextField surnameTF, JPasswordField passwordField,
            JTextField ppsnTF, JTextField genderTF, JTextField emailTF, JTextField phoneNumberTF,
            JTextField addressLineOneTF, JTextField addressLineTwoTF, JTextField cityTF,
            JTextField eircodeTF, JTextField dobTF) {
        
                Teacher t1 = new Teacher(firstNameTF.getText().toString(), surnameTF.getText().toString(), passwordField.getPassword().toString(),
                ppsnTF.getText().toString(), genderTF.getText().toString(), emailTF.getText().toString(), phoneNumberTF.getText().toString(),
                addressLineOneTF.getText().toString(), addressLineTwoTF.getText().toString(), cityTF.getText().toString(),
                eircodeTF.getText().toString(), dobTF.getText().toString());
        
        String sql = "INSERT INTO teacher (admin_id, first_name, sur_name, password, PPSN, gender, email,\n"
                + "phone_number, address_line_one, address_line_two, city, eircode, date_of_birth)\n"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            prest = con.prepareStatement(sql);

            prest.setString(1, adminId);
            prest.setString(2, t1.getFirst_name());
            prest.setString(3, t1.getSur_name());
            prest.setString(4, t1.getPassword());
            prest.setString(5, t1.getPPSN());
            prest.setString(6, t1.getGender());
            prest.setString(7, t1.getEmail());
            prest.setString(8, t1.getPhone_number());
            prest.setString(9, t1.getAddress_line_one());
            prest.setString(10, t1.getAddress_line_two());
            prest.setString(11, t1.getCity());
            prest.setString(12, t1.getEircode());
            prest.setString(13, t1.getDate_of_birth());

            prest.executeUpdate();

            DisplayMessage("✅ New Teacher Succesfully Added");


        } catch (SQLException e) {
            DisplayMessage("❌ New Teacher Adding Failed\n Make sure all the fields are filled");
            System.err.println("❌ Database error: " + e.getMessage());
        }
    }
    
    // Deleting Teacher Record at TeacherInfoFrame
    public void deleteTeacher(JTextField teacherIdTF, JTextField firstNameTF, JTextField surnameTF){
//        Teacher t1 = new Teacher(teacherIdTF.getText().toString());
//        t1.setFirst_name(firstNameTF.getText().toString());
//        t1.setSur_name(surnameTF.getText().toString());
//        t1.setFull_name(t1.getFirst_name() + " " + t1.getSur_name());
//        
//
//        int confirm = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete "
//                + t1.getTeacher_id() + " " + t1.getFull_name() + " from GTI Teacher record");
//
//        if (confirm == 0) {
//
//            try {
//                String sql = "DELETE FROM teacher WHERE teacher_id = ?";
//                prest = con.prepareStatement(sql);
//                prest.setString(1, t1.getTeacher_id());
//
//                int del = prest.executeUpdate();
//
//                if (del > 0) {
//                    DisplayMessage("✅ " + t1.getFull_name() + " deleted successfully!");
//                } else {
//                    DisplayMessage("⚠ No record found for this student and subject.");
//                }
//            } catch (SQLException e) {
//                System.err.println("❌ Database error: " + e.getMessage());
//            }
//        }
    }

    // Fetching all students by class_code
    public void studentsByClassCode(JTable table, String courseId) {
        try {

            Student s1 = new Student();

            String sql = "SELECT student.* FROM student\n"
                    + "INNER JOIN class_group ON student.class_code = class_group.class_code\n"
                    + "WHERE student.class_code = ?";

            prest = con.prepareStatement(sql);
            prest.setString(1, courseId);

            ResultSet rs = prest.executeQuery();

            DefaultTableModel tableModel1 = (DefaultTableModel) table.getModel();
            tableModel1.getDataVector().removeAllElements();
            if (!rs.next()) {
                DisplayMessage("Student Not Found!!!");
            } else {
                do {
                    Vector row = new Vector();
                    s1.setStudent_id(rs.getString(1));
                    s1.setFirst_name(rs.getString(4));
                    s1.setSur_name(rs.getString(5));
                    row.add(s1.getStudent_id());
                    row.add(s1.getFirst_name() + " " + s1.getSur_name());
//                    s1.setSubject_id(rs.getString(3));
//                    s1.setFirst_grade(rs.getDouble(4));
//                    s1.setSecond_grade(rs.getDouble(5));
//                    s1.setThird_grade(rs.getDouble(6));
//                    s1.setFinal_exam(rs.getDouble(7));
//                    s1.setOver_all(rs.getDouble(8));
//                    row.add(s1.getSubject_id());
//                    row.add(s1.getFirst_grade());
//                    row.add(s1.getSecond_grade());
//                    row.add(s1.getThird_grade());
//                    row.add(s1.getFinal_exam());
//                    row.add(s1.getOver_all());
                    tableModel1.addRow(row);
                } while (rs.next());
            }
            prest.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Encryption and Decryption
    public class CryptoUtils {

    private static final String SECRET_KEY = "MySecretKey12345"; // 16-char key

    public static String encrypt(String strToEncrypt) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // Add padding
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String strToDecrypt) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // Add padding
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decodedBytes = Base64.getDecoder().decode(strToDecrypt);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);

            return new String(decryptedBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

//    public static void main(String[] args) {
//        Controllers connect = new Controllers();
//    }
}
