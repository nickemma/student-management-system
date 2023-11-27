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
        int id;

        do {
            System.out.print("Enter student ID: ");
            id = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            if (isIdAlreadyUsed(id)) {
                System.out.println("Student with this ID already exists. Please use a different ID.");
            }
        } while (isIdAlreadyUsed(id));

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();

        students.add(new Student(name, id, age, grade));
        totalStudents++;

        System.out.println("Student added successfully.");
    }

    private static boolean isIdAlreadyUsed(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true; // ID is already used
            }
        }
        return false; // ID is unique
    }
  
  private static void updateStudentInformation(Scanner scanner) {
      System.out.print("Enter student ID to update: ");
      int searchId = scanner.nextInt();
      int index = findStudentIndex(searchId);

      if (index != -1) {
          System.out.println("Choose the field to update:");
          System.out.println("1. Name");
          System.out.println("2. Age");
          System.out.println("3. Grade");
          System.out.println("4. Update All Fields");

          int fieldChoice = scanner.nextInt();
          scanner.nextLine(); // consume the newline character

          switch (fieldChoice) {
              case 1:
                  System.out.print("Enter updated student name: ");
                  String newName = scanner.nextLine();
                  students.get(index).setName(newName);
                  break;
              case 2:
                  System.out.print("Enter updated student age: ");
                  int newAge = scanner.nextInt();
                  students.get(index).setAge(newAge);
                  break;
              case 3:
                  System.out.print("Enter updated student grade: ");
                  double newGrade = scanner.nextDouble();
                  students.get(index).setGrade(newGrade);
                  break;
              case 4:
                  System.out.print("Enter updated student name: ");
                  String updatedName = scanner.nextLine();
                  System.out.print("Enter updated student age: ");
                  int updatedAge = scanner.nextInt();
                  scanner.nextLine(); // consume the newline character
                   System.out.print("Enter updated student grade: ");
                  double updatedGrade = scanner.nextDouble();

                  // Update all fields at once
                  Student student = students.get(index);
                  student.setName(updatedName);
                  student.setAge(updatedAge);
                  student.setGrade(updatedGrade);
                  break;
              default:
                  System.out.println("Invalid choice. No fields updated.");
                  return;
          }

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
