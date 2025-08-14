package com.task;

import java.io.*;
import java.util.*;


class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private final String FILE_NAME = "students.data";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getRollNumber() == student.getRollNumber()) {
                System.out.println("Error: Student with this roll number already exists!");
                return;
            }
        }
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        Student found = searchStudent(rollNumber);
        if (found != null) {
            students.remove(found);
            saveToFile();
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Error: Student not found.");
        }
    }

    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void editStudent(int rollNumber, String newName, String newGrade) {
        Student found = searchStudent(rollNumber);
        if (found != null) {
            if (!newName.isEmpty()) found.setName(newName);
            if (!newGrade.isEmpty()) found.setGrade(newGrade);
            saveToFile();
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Error: Student not found.");
        }
    }

    // Save data to file
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}

// Main Class with Console UI
public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\n--------- Student Management System ---------");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number between 1 and 6.");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Error: Name and Grade cannot be empty.");
                    } else {
                        sms.addStudent(new Student(name, roll, grade));
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number to Remove: ");
                    int removeRoll = sc.nextInt();
                    sms.removeStudent(removeRoll);
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRoll = sc.nextInt();
                    Student found = sms.searchStudent(searchRoll);
                    if (found != null) {
                        System.out.println("Student Found: " + found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.print("Enter Roll Number to Edit: ");
                    int editRoll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name : ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Grade : ");
                    String newGrade = sc.nextLine();
                    sms.editStudent(editRoll, newName, newGrade);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter between 1 and 6.");
            }
        } while (choice != 6);

        sc.close();
    }
}
