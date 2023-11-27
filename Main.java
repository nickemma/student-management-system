import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private int age;
    private double grade;

    public Student(String name, int id, int age, double grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static int totalStudents = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    updateStudentInformation(scanner);
                    break;
                case 3:
                    viewStudentDetails(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addNewStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();

        students.add(new Student(name, id, age, grade));
        totalStudents++;

        System.out.println("Student added successfully.");
    }

    private static void updateStudentInformation(Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int searchId = scanner.nextInt();
        int index = findStudentIndex(searchId);

        if (index != -1) {
            System.out.print("Enter updated student grade: ");
            double newGrade = scanner.nextDouble();
            students.get(index).setGrade(newGrade);
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    private static void viewStudentDetails(Scanner scanner) {
        System.out.print("Enter student ID to view details: ");
        int searchId = scanner.nextInt();
        int index = findStudentIndex(searchId);

        if (index != -1) {
            Student student = students.get(index);
            System.out.println("Student Details:");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Age: " + student.getAge());
            System.out.println("Grade: " + student.getGrade());
        } else {
            System.out.println("Student ID not found.");
        }
    }

    private static int findStudentIndex(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1; // Not found
    }
}
