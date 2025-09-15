# Record Keeping System

A Java Swing desktop application for managing student records, designed as my final project for the GTI Advanced Software Development course. The application features full CRUD functionality, user authentication, and report generation.

**Watch presentation [video](https://drive.google.com/file/d/1ApvT9w1lkOBx3_hYg8qCZSZCIkDX0XsW/view?usp=sharing).**

## Getting Started
To run the application, download the `shaded-snapshot.jar` file from this repository. You will also need to have Java installed on your machine.

**Login Credentials:**
* **Admin:** `admin@gretb.ie` / `admin123`
* **Teacher:** `johndoe@gretb.ie` / `john123`

## Example Screenshots
![Login Page Screenshot](./GTI-Record-Keeping-System/login-page.png)
![Single Student Manupulation Screenshot](./GTI-Record-Keeping-System/single-student.png)
![Student Info ScreenShot](./GTI-Record-Keeping-System/student-info.png)
![Class Group Table Format ScreenShot](./GTI-Record-Keeping-System/class-group.png)
![Certification ScreenShot](./GTI-Record-Keeping-System/graduation-report.png)


## Features

* **Secure User Authentication:** Users can log in to access the application.
* **CRUD Functionality:** Easily Create, Read, Update, and Delete student records from the database.
* **Dynamic Data Tables:** View all students in a clear, sortable table.
* **Search Functionality:** Quickly find specific students by name or other criteria.
* **Certification:** Save & print student graduation certificate.

## Tech Stack

* **Backend:** Java, NetBeans, Maven
* **Frontend:** Java Swing
* **Database:** MySQL (Hosted on AWS RDS)
* **Version Control:** Git / GitHub

## Challenges & Lessons Learned

"A key challenge was managing the state of dependent combo boxes, where selecting an item in one list (e.g., "Class") should filter the results in another (e.g., "Student"). My initial event-driven approach caused a bug where refreshing one combo box would unintentionally clear the data in others.

I refactored the design by decoupling the data-fetching logic from the combo box selection event. I introduced a dedicated "Search" button to execute the database query. This gave me more precise control over the UI state, resolved the bug, and created a more stable and predictable user experience."

