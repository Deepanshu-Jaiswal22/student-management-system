package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        studentservice service = new studentservice();

        char ch= 'y';

        do {

            System.out.println("\n==============================");
            System.out.println("       STUDENT MANAGEMENT");
            System.out.println("==============================");

            System.out.println("1. add student");
            System.out.println("2. find student");
            System.out.println("3. update profile");
            System.out.println("4. remove profile");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter roll number: ");
                    String RollNumber = sc.nextLine();

                    System.out.print("Enter student Name: ");
                    String studentName = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    student st = new student(
                            RollNumber,
                            studentName,
                            course
                    );
                    System.out.println("Roll: " + RollNumber);
                    System.out.println("Name: " + studentName);
                    System.out.println("Course: " + course);

                    service.createAccount(st);

                    break;

                case 2:

                    System.out.print("Enter student ID: ");

                    Long id = sc.nextLong();

                    student foundAccount = service.findById(id);

                    if (foundAccount != null) {
                        System.out.println("\nstudent Found:");
                        System.out.println(foundAccount);
                    } else {
                        System.out.println("student not found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter student ID to update: ");
                    Long updateid = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter new roll number: ");
                    String rollNumber = sc.nextLine();

                    System.out.print("Enter new student name: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter new course: ");
                    String updatecourse = sc.nextLine();

                    service.updatestudent(updateid, rollNumber, updateName, updatecourse);

                    break;
                case 4:

                    System.out.print("Enter student ID to delete: ");
                    Long deleteId = sc.nextLong();
                    sc.nextLine();

                    service.deletestudent(deleteId);

                    break;

                case 5:

                    System.out.println("Thank you!");
                    return;

                default:

                    System.out.println("Invalid choice!");


            }

            System.out.print("\nDo you want to continue? Press Y/N: ");
            ch = sc.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');

        sc.close();
    }
}
