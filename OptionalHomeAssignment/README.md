#Database Localization Project

##Introduction:
Database localization involves storing data in a database in a language-specific manner to cater to users from different linguistic backgrounds.
This readme.md provides an overview of the database localization approach implemented in the "Add Employee" feature of the application.

##Objective:
The objective of database localization is to enable the storage of data in multiple languages, ensuring that user-entered information
is saved in the appropriate language-specific tables.

##Implement overview:
Locale Selection: In your JavaFX application, users can select their preferred language from a dropdown menu. 
The available options are English, Nepali, and Japanese.
ResourceBundle: You use ResourceBundle to manage localized resources, such as labels and button text, for different languages.
Each language has its own properties file (messages_en_UK.properties, messages_fa_IR.properties, messages_ja_JP.properties) 
containing localized strings.
UI Update: When the user selects a language from the dropdown menu, the UI elements such as labels, text fields, and
buttons are updated with text retrieved from the corresponding ResourceBundle.
Data Localization: When the user enters employee data and clicks the "Save" button, the entered data is saved into the database. 
However, instead of saving all data into a single table, you have separate tables for each language (employee_en, employee_ne, employee_ja). 
The table used depends on the selected language.
Table Selection:Based on the selected language, a corresponding table name (employee_en, employee_ne, employee_ja) is determined.
For example, if the user selects Nepali, data will be saved into the employee_ne table.
Insertion into Database:The e data (first name, last name, email) is inserted into the determined table using an SQL INSERT statement.
Error Handling: If an error occurs during the database operation (e.g., connection failure, data truncation), an error message is displayed
to the user using an alert dialog.

##Prerequisites:
-Java JDK 17 or newer
-MySQL or MariaDB server or JDBC driver
-Maven (for dependency management)


##SetUp
Java Application to Add Records to the Employees Table: The Java application AddEmployees.java adds records to the employee's table in the MySQL or MariaDB database.
Here's a brief overview of the application:

1.It establishes a connection to the MySQL database using JDBC.
2.It prepares an SQL INSERT statement to add a new employee record to the employee's table.
3.It prompts the user to enter the employee details such as name, age, and salary.
4.It executes the INSERT statement with the provided employee details.
5.If successful, it displays a message confirming the insertion of the employee record.
6.If an error occurs during the insertion process, it catches the exception and prints the error message.

##To run the application:

1.Open the project in your preferred Java IDE (e.g., IntelliJ IDEA).
2.Ensure that the MySQL Connector/J library is included in your project's dependencies.
3.Run the AddEmployees.java file.
4.Follow the prompts to enter the employee details (first_name, last_name, email).
5.The application will attempt to add the employee record to the database.
6.If successful, a message confirming the insertion will be displayed. If an error occurs, an error message will be shown.
7.Ensure that your MySQL database is running and accessible, and that the table structure matches the employees table described above.



