import java.util.ArrayList;
import java.util.Scanner;

// Student class to represent a student with name, ID, age, and grade
class Student {
    private String name;
    private int id;
    private int age;
    private double grade;

        // Constructor to initialize the student object
    public Student(String name, int id, int age, double grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

        // Getters to retrieve the values of private instance variables
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

       // Setters to update the values of private instance variables
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

// Main class containing the program logic
public class Main {
    private static ArrayList<Student> students = new ArrayList<>(); // List to store student objects
    private static int totalStudents = 0; // Counter for the total number of students

        // Main method where the program execution starts
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        int choice;

                // Do-while loop for the main menu until the user chooses to exit (option 6)
        do {
                        // Displaying the main menu
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. View All Students");
            System.out.println("5. Delete A Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt(); // User input for the menu choice
            scanner.nextLine(); // consume the newline character

                        // Switch statement to perform actions based on the user's choice
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
                    viewAllStudents();
                    break;
                case 5:
                    deleteStudent(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6); // Continue the loop until the user chooses to exit

        scanner.close(); // Close the scanner to prevent resource leak
    }

        // Method to add a new student to the list
    private static void addNewStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int id;
        // Validate and ensure the uniqueness of the student ID
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

        // Create a new student object and add it to the list
        students.add(new Student(name, id, age, grade));
        totalStudents++;

        System.out.println("Student added successfully.");
    }

    // Method to check if a student ID is already used
    private static boolean isIdAlreadyUsed(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true; // ID is already used
            }
        }
        return false; // ID is unique
    }
  
        // Method to update student information based on user input
  private static void updateStudentInformation(Scanner scanner) {
      System.out.print("Enter student ID to update: ");
      int searchId = scanner.nextInt();
      int index = findStudentIndex(searchId);

      if (index != -1) {
                    // Display options to choose the field to update
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
    // Method to view details of a specific student based on user input
    private static void viewStudentDetails(Scanner scanner) {
        System.out.print("Enter student ID to view details: ");
        int searchId = scanner.nextInt();
        int index = findStudentIndex(searchId);

        if (index != -1) {
                        // Display details of the selected student
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
    // Method to view details of all students
    private static void viewAllStudents() {
      if (students.isEmpty()) {
          System.out.println("No students available. Please add students first.");
      } else {
            // Display details (ID and name) of all students
          System.out.println("List of All Students:");
          for (Student student : students) {
              System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
          }
      }
  }
    // Method to delete a student based on user input
  private static void deleteStudent(Scanner scanner) {
      System.out.print("Enter student ID to delete: ");
      int deleteId = scanner.nextInt();
      int index = findStudentIndex(deleteId);

      if (index != -1) {
        // Remove the selected student from the list
          students.remove(index);
          totalStudents--;
          System.out.println("Student deleted successfully.");
      } else {
          System.out.println("Student ID not found. Deletion failed.");
      }
  }
    // Method to find the index of a student in the list based on ID
    private static int findStudentIndex(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i; // Return the index if the student is found
            }
        }
        return -1; // Not found
    }
}
