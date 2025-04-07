import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecordManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            System.out.println("Choose one of the option from below: ");
            System.out.println("1. Add Student");
            System.out.println("2. View all students");
            System.out.println("3. Search student by roll number");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit");

            int choice = 0;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                while (choice < 0 || choice > 5) {
                    System.out.println("Please enter a valid option");
                    choice = sc.nextInt();
                }
            } else {
                System.out.println("Please enter a valid option");
            }
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name, roll number and marks in comma separated format: ");
                    String name = sc.nextLine();
                    String[] items = name.split("\\s*,\\s*");
                    list.add(new Student(items[0], items[1], Integer.parseInt(items[2])));
                    break;
                case 2:
                    for (Student student : list) {
                        System.out.println(student);
                    }
                    break;
                case 3:
                    System.out.println("Enter roll number to search: ");
                    String searchRoll = sc.nextLine();
                    boolean found = false;
                    for (Student student : list) {
                        if (student.roll_number().equals(searchRoll)) {
                            System.out.println("Student found: " + student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with roll number " + searchRoll + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter roll number to delete: ");
                    String deleteRoll = sc.nextLine();
                    boolean deleted = list.removeIf(s -> s.roll_number().equals(deleteRoll));
                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("No student with that roll number found.");
                    }
                    break;
                case 5:
                    flag = false;
            }
        }
    }
}

record Student(String name, String roll_number, int marks) { }
