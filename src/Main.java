import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        int choice = 0;

        do {

            System.out.println("\n======================================================");
            System.out.println("   Mini Bioinformatics Laboratory Management System");
            System.out.println("======================================================");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {

                choice = input.nextInt();

                switch (choice) {

                    case 1:

                        String role = login.login();

                        if (role != null) {

                            LaboratoryMenu menu = new LaboratoryMenu();
                            menu.menu(role);

                        }

                        break;

                    case 2:

                        System.out.println("\nThank you for using the system.");

                        break;

                    default:

                        System.out.println("\nInvalid choice. Please try again.");

                }

            } else {

                System.out.println("\nPlease enter a valid number.");
                input.next();
            }

        } while (choice != 2);

        input.close();
    }
}