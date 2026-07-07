import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        int choice;

        do{

            System.out.println("==== Welcome to Mini Bioinformatics Laboratory Management System ====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();

            switch(choice){

                case 1:

                    String role = login.login();

                    if (role != null) {

                        LaboratoryMenu menu = new LaboratoryMenu();
                        menu.menu(role);

                    }

                    break;

                case 2:

                    System.out.println("Thank you!");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        }while(choice != 2);

    }

}