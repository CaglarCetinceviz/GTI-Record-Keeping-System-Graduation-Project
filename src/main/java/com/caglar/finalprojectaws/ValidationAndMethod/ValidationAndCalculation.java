package com.caglar.finalprojectaws.ValidationAndMethod;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
//import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JPasswordField;

/**
 *
 * @author cagla
 */
public class ValidationAndCalculation {

    // Display Method
    public static void DisplayMessage(String answer) {
        JOptionPane.showMessageDialog(null, answer);
    }

    // Invalid Input Error
    public static void InvalidInput() {
        JOptionPane.showMessageDialog(null, "Invalid input");
    }

    // Invalid login Error
    public static void Invalidlogin() {
        JOptionPane.showMessageDialog(null, "Invalid input. Check the Username & Password");
    }

    // Method to add two number
    public static double AdditionOfTwoNumbers(double n1, double n2) {
        double result = n1 + n2;
        return result;
    }

    // Method to multiplication two numbers
    public static double MultiplicationOfTwoNumbers(double n1, double n2) {
        double result = n1 * n2;
        return result;
    }

    // Method to substraction two numbers
    public static double SubstrationOfTwoNumbers(double n1, double n2) {
        double result = n1 - n2;
        return result;
    }

    // Method to divide two numbers
    public static double DivideOfTwoNumbers(double n1, double n2) {
        double result = n1 / n2;
        return result;
    }

    // Validate Double
    public static double ValidateDouble(String value) {
        double input = 0;
        try {
            input = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            InvalidInput();
            System.out.println(e);
        }
        return input;
    }

    // Validate Integer
    public static int ValidateInteger(String text) {
        int num = 0;
        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            InvalidInput();
        }
        return num;
    }

    // Decimal Digit Validation
    public static void DecimalDigitValidation(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        if (!(Character.isDigit(key) || key == '.')) {
            evt.consume();
        }
    }

    public static void dateValidation(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        if (!(Character.isDigit(key) || key == '.')) {
            evt.consume();
        }
    }

    // Letter Validation
    public static void LetterValidation(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        if (!(Character.isLetter(key) || Character.isSpaceChar(key)) || key == '-') {
            evt.consume();
        }
    }

    // Digit Validation
    public static void DigitValidation(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        if (!(Character.isDigit(key)) || Character.isSpaceChar(key)) {
            evt.consume();
        }
    }

    // Letter Or Digit Validation
    public static void LetterOrDigitValidation(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        if (!(Character.isLetter(key) || Character.isDigit(key)) || Character.isSpaceChar(key)) {
            evt.consume();
        }
    }

    // Letter Or Digit Validation or Space
    public static void LetterOrDigitOrSpaceValidation(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        if (!(Character.isLetter(key) || Character.isDigit(key) || Character.isSpaceChar(key))) {
            evt.consume();
        }
    }

    /**
     *
     * @param evt
     * @param field
     * @param value
     */
    public static void LenghtValidation(java.awt.event.KeyEvent evt, JTextField field, int value) {
        if ((field.getText().length() >= value)) {
            evt.consume();
        }
    }

    public static double RoundMoney(double money) {
        double roundedMoney = 0.0;
        roundedMoney = Math.round(money * 100) / 100.0;
        return roundedMoney;
    }

    public static void SymbolValidation(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        if (!(key == '@' || key == '!')) {
            evt.consume();
        }
    }

    // Save PDF method
    public static void saveAsPDF(String studentName, String StudentSurname, String classCode, String ppsn, String gender, String DOB,
            String email, String phone, String address1, String address2, String city, String eircode, JTable table) {
        String filePath = "C:/" + studentName + "_" + StudentSurname + "_grades.pdf";

        try {
            // Create a PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Define fonts
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLUE);
            Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Font textFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

            // Load the logo image from the folder
            Image logo = Image.getInstance("C:/Users/cagla/OneDrive/Documents/NetBeansProjects/RecordKeepingSystem/src/Images/gti-logo.png"); // Adjust the path
            logo.scaleToFit(100, 100); // Resize (width, height)
            logo.setAlignment(Image.ALIGN_CENTER); // Center align
            document.add(logo); // Add logo to the PDF

            // 🔹 Add some space after the logo
            document.add(new Paragraph("\n"));

            // Title
            Paragraph title = new Paragraph("Student Report\n\n", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Create a table (2 columns) for Personal & Contact Details
            PdfPTable detailsTable = new PdfPTable(2);
            detailsTable.setWidthPercentage(100); // Full width
            detailsTable.setSpacingAfter(10); // Add space after table
            detailsTable.setWidths(new float[]{1, 1}); // 50-50 column width

            // Personal Details Panel
            PdfPCell personalDetails = new PdfPCell();
            personalDetails.addElement(new Paragraph("Personal Details\n", sectionFont));
            personalDetails.addElement(new Paragraph("Student Name: " + studentName, textFont));
            personalDetails.addElement(new Paragraph("Student Surname: " + StudentSurname, textFont));
            personalDetails.addElement(new Paragraph("Student Class Code: " + classCode, textFont));
            personalDetails.addElement(new Paragraph("Student PPSN: " + ppsn, textFont));
            personalDetails.addElement(new Paragraph("Student Gender: " + gender, textFont));
            personalDetails.addElement(new Paragraph("Student Date of Birth: " + DOB, textFont));
            personalDetails.setPadding(10);
            personalDetails.setBorder(Rectangle.BOX);
            detailsTable.addCell(personalDetails);

            // 🔹 Contact Details Panel
            PdfPCell contactDetails = new PdfPCell();
            contactDetails.addElement(new Paragraph("Contact Details\n", sectionFont));
            contactDetails.addElement(new Paragraph("Email: " + email, textFont));
            contactDetails.addElement(new Paragraph("Phone: " + phone, textFont));
            contactDetails.addElement(new Paragraph("Address Line One: " + address1, textFont));
            contactDetails.addElement(new Paragraph("Address Line Two: " + address2, textFont));
            contactDetails.addElement(new Paragraph("City: " + city, textFont));
            contactDetails.addElement(new Paragraph("Eircode: " + eircode, textFont));
            contactDetails.setPadding(10);
            contactDetails.setBorder(Rectangle.BOX);
            detailsTable.addCell(contactDetails);

            document.add(detailsTable);

            Paragraph graduationText = new Paragraph(
                    "This is to certify that " + studentName.toUpperCase() + " " + StudentSurname.toUpperCase() + ", having successfully completed "
                    + "all required coursework and assessments in the " + classCode
                    + " has met the academic standards set forth by the institution. "
                    + "In recognition of their dedication and achievement, we are pleased to confirm "
                    + "their graduation for the academic year 2024/2025. "
                    + "We congratulate " + studentName.toUpperCase() + " on this milestone and wish them success in their future endeavors.\n\n\n\n",
                    textFont
            );
            document.add(graduationText);

            // 🔹 Assessment Results Panel (Full Width)
            Paragraph assessmentTitle = new Paragraph("Assessment Results\n\n", sectionFont);
            document.add(assessmentTitle);

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Table Headers
            TableModel model = table.getModel();
            for (int col = 0; col < model.getColumnCount(); col++) {
                PdfPCell header = new PdfPCell(new Phrase(model.getColumnName(col), sectionFont));
                header.setBackgroundColor(BaseColor.BLUE);
                pdfTable.addCell(header);
            }

            // Table Data
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    pdfTable.addCell(new PdfPCell(new Phrase(model.getValueAt(row, col).toString(), textFont)));
                }
            }

            document.add(pdfTable);

            document.close();
            System.out.println("✅ PDF saved successfully at: " + filePath);

        } catch (Exception e) {
            System.err.println("❌ Error creating PDF: " + e.getMessage());
        }

        // To open the file "C:/OOP/..."
        try {
            File file = new File("C:/" + studentName + "_" + StudentSurname + "_grades.pdf"); // File to open

            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            // Open the file using the default system application
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } else {
                System.out.println("Desktop is not supported on this system.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void emailValidation(java.awt.event.KeyEvent evt, JTextField emailTF) {
        char typedChar = evt.getKeyChar();

        // Skip backspace or delete
        if (Character.isISOControl(typedChar)) {
            return;
        }

        String currentText = emailTF.getText();
        String fullText = currentText + typedChar;

        // Loose regex while typing (no full validation yet)
        String emailRegex = "^[A-Za-z0-9+_.-]*@?[A-Za-z0-9.-]*$";

        if (!fullText.matches(emailRegex)) {
            evt.consume(); // block the character
            emailTF.setForeground(Color.RED);
        } else {
            emailTF.setForeground(Color.BLACK);
        }
    }

    public static void passwordValidation(JPasswordField passwordField) {
        String password = new String(passwordField.getPassword());  // get password as String

        // Example: only letters and numbers, at least 6 characters
        String passwordRegex = "^[a-zA-Z0-9]{6,}$";

        if (!password.matches(passwordRegex)) {
            DisplayMessage("Password must be at least 6 characters and contain only letters or numbers."
                    + "Invalid Password");
            passwordField.requestFocus();
            return;
        }
    }

    public static void fillTheField(JTextField firstNameTF) {
        if (firstNameTF.getText().toString().isEmpty()) {
            DisplayMessage("Fill the Field");
            firstNameTF.requestFocus();
        }
    }
}
