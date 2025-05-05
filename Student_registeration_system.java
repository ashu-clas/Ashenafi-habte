
/*GROUP MEMBER         ID
 1.ASHENAFI HABTE   GUR/02264/15
 2.AMANUAL AZANAW   GUR/02595/15
 3.NATINAEL GETNET  GUR/01640/15   
 4.GETAHUN NIGUSSE  GUR/02621/15
 5.HILLINA MEKURIAW GUR/02729/15
*/
  




package com.mycompany.student_registeration_system;

import static java.lang.System.exit;
import java.util.Scanner;
import java.util.InputMismatchException;

// Base class
class Person {
     public String name;
     public String phoneNumber;
     public String email;

    public Person(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and setters method
    

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
   
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

     public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
}

// Derived  Student class (inheritance)
class Student extends Person {
    private int id;
    private String department;
    private String[] courses;
    private int courseCount;

    public Student(int id, String name, String phoneNumber, String email, 
                  String department, int maxCourses) {
        super(name, phoneNumber, email);
        this.id = id;
        this.department = department;
        this.courses = new String[maxCourses];
        this.courseCount = 0;
    }

    // Polymorphism - method overriding
    public void displayInfo() {
        System.out.println("full student information is:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.print("Courses: ");
        for (int i = 0; i < courseCount; i++) {
            System.out.print(courses[i]);
            if (i < courseCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Getters and setters
    

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
  
    public String getDepartment() {
        return department;
    }
    public void addCourse(String course) {
        if (courseCount < courses.length) {
            courses[courseCount] = course;
            courseCount++;
        } else {
            System.out.println("Cannot add more courses. Maximum limit is reached.");
        }
    }

    public String[] getCourses() {
        return courses;
    }
}

class StudentRegistration {
    public Student[] students;
    public int counter;
    public int MAX_COURSES = 6; // Maximum courses per student
    
    public StudentRegistration(int maxStudents) {
        students = new Student[maxStudents];
        counter = 0;
    }
    
    public void register(int id, String name, String phoneNumber, String email,
                       String department, String[] courses) {
        if (counter < students.length) {
            Student student = new Student(id, name, phoneNumber, email, department, MAX_COURSES);
            for (String course : courses) {
                if (course != null && !course.isEmpty()) {
                    student.addCourse(course);
                }
            }
            students[counter] = student;
            counter++;
        }
    }
    
    public void viewStudents() {
        if (counter == 0) {
            System.out.println("There are no registered students");
        } else {
            for (int i = 0; i < counter; i++) {
                students[i].displayInfo();
            }
        }
    }
    
    public void deleteStudent(int id) {


boolean found = false;
        for (int i = 0; i < counter; i++) {
            if (students[i].getId() == id) {
                found = true;
                // Shift all elements after the found student one position left
                for (int j = i; j < counter - 1; j++) {
                    students[j] = students[j + 1];
                }
                counter--;
                System.out.println("Student with ID " + id + " deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
    
    public int countStudents() {
        return counter;
    }
    
    // the method to search student by ID fron studentes
    public void searchStudentById(int id) {
        boolean found = false;
        for (int i = 0; i < counter; i++) {
            if (students[i].getId() == id) {
                students[i].displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}

public class Student_registeration_system {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StudentRegistration str = new StudentRegistration(1000);
        
        while (true) {
            System.out.println("\n================Welcome to Student Registration System to get any servise=========================");
            System.out.println("ENTER 1. Register many Studentes ");
            System.out.println("ENTER 2. View Registered Students in thes system");
            System.out.println("ENTER 3. Delete Student when the student is already registered");
            System.out.println("ENTER 4. Count all Registered Students");
            System.out.println("ENTER 5. Search Student by ID from registered studentes");
            System.out.println("ENTER 6. Exit exit the system ");
            System.out.print("Enter your choice to get any servise from the above choice: ");
            System.out.print("!!!!!!!!!befor you choised you must be sure what you want!!!!!!!!!! ");

            try {
                int choice = s.nextInt();
                s.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter ID: ");
                            int id = s.nextInt();
                            
                            System.out.print("Enter Name: ");
                            String name = s.nextLine();
                            
                            System.out.print("Enter Phone Number: ");
                            String phoneNumber = s.nextLine();
                            
                            System.out.print("Enter Email: ");
                            String email = s.nextLine();
                            
                            System.out.print("Enter Department: ");
                            String department = s.nextLine();
                            
                            String[] courses = new String[6]; // Max 6 courses
                            System.out.println("Enter up to 6 courses for each student and enter to skip :");
                            for (int i = 0; i < 6; i++) {
                                System.out.print("Course " + (i+1)+"..is: ");
                                String course = s.nextLine();
                                if (!course.isEmpty()) {
                                    courses[i] = course;
                                }
                            }
                            
                            str.register(id, name, phoneNumber, email, department, courses);
                            System.out.println("Student registered successfully!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input format. Please enter appropret input like number  for ID.");
                            s.nextLine(); // Clear the invalid input or consume line 


                      } catch (Exception e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        }
                        break;
                        
                    case 2:
                        str.viewStudents();
                        break;
                        
                    case 3:
                        try {
                            System.out.print("Enter  Student ID you want to delete: ");
                            int deleteId = s.nextInt();
                            s.nextLine();
                            str.deleteStudent(deleteId);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input format. Please enter numbers for ID.");
                            s.nextLine(); // Clear the invalid input
                        }
                        break;
                        
                    case 4:
                        System.out.println("Total registered students: " + str.countStudents());
                        break;
                        
                    case 5:
                        try {
                            System.out.print("Enter Student ID to search: ");
                            int searchId = s.nextInt();
                            s.nextLine();
                            str.searchStudentById(searchId);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input format. Please enter numbers for ID.");
                            s.nextLine(); // Clear the invalid input
                        }
                        break;
                        
                    case 6:
                        System.out.println("-----------------Exiting system...");
                        exit(0);
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Please enter 1-6.to get a ");
                }
            } catch (InputMismatchException e) {
                System.out.println("An error occurred: " + e.getMessage());
                s.nextLine(); // Clear the buffer
            }
        }
    }
}