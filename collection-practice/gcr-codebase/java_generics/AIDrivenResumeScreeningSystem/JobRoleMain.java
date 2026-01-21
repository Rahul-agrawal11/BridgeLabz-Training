package java_generics.AIDrivenResumeScreeningSystem;

import java.util.Scanner;

public class JobRoleMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        // Separate resume buckets for each role
        Resume<SoftwareEngineer> engineerResume = new Resume<>();
        Resume<DataScientist> scientistResume = new Resume<>();
        Resume<ProductManager> managerResume = new Resume<>();

        while (true) {

            System.out.println("\n====== AI Driven Resume Screening System ======");
            System.out.println("1. Add Software Engineer Resume");
            System.out.println("2. Add Data Scientist Resume");
            System.out.println("3. Add Product Manager Resume");
            System.out.println("4. Display All Resumes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    engineerResume.addResume(
                        new SoftwareEngineer("Rahul", 1)
                    );
                    System.out.println("Software Engineer resume added");
                    break;

                case 2:
                    scientistResume.addResume(
                        new DataScientist("Sagar", 1)
                    );
                    System.out.println("Data Scientist resume added");
                    break;

                case 3:
                    managerResume.addResume(
                        new ProductManager("Ram", 2)
                    );
                    System.out.println("Product Manager resume added");
                    break;

                case 4:
                    Utility.displayDetails(engineerResume.getResumes());

                    Utility.displayDetails(scientistResume.getResumes());

                    Utility.displayDetails(managerResume.getResumes());
                    break;

                case 5:
                    System.out.println("Exiting Resume Screening System");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
