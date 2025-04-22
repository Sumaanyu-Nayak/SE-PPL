package university.main;

import university.persons.*;
import university.services.*;
import java.util.*;

public class UniversityApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Role[] roles = new Role[3];

        System.out.println("Enter Student Details:");
        System.out.print("Name: ");
        String sName = scanner.nextLine();
        System.out.print("Age: ");
        int sAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Student ID: ");
        String sId = scanner.nextLine();
        System.out.print("Course: ");
        String course = scanner.nextLine();
        roles[0] = new Student(sName, sAge, sId, course);

        System.out.println("\nEnter Faculty Details:");
        System.out.print("Name: ");
        String fName = scanner.nextLine();
        System.out.print("Age: ");
        int fAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Faculty ID: ");
        String fId = scanner.nextLine();
        System.out.print("Subject: ");
        String subject = scanner.nextLine();
        roles[1] = new Faculty(fName, fAge, fId, subject);

        System.out.println("\nEnter Admin Details:");
        System.out.print("Department: ");
        String dept = scanner.nextLine();
        roles[2] = new Admin(dept);

        System.out.println("\nDisplaying Roles and Info:\n");
        for (Role r : roles) {
            r.showRole();
            if (r instanceof Person) {
                ((Person) r).displayInfo();
            } else if (r instanceof Admin) {
                ((Admin) r).displayInfo();
            }
            System.out.println();
        }

        scanner.close();
    }
}
