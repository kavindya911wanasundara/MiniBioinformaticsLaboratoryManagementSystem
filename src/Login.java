import java.util.Scanner;

public class Login {

    User[] users = {
            new User("admin", "admin123", "Admin"),
            new User("tech", "tech123", "Technician"),
            new User("research", "research123", "Researcher")
    };

    public String login() {

        Scanner input = new Scanner(System.in);

        System.out.println("\n========== Login ==========");

        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        for (int i = 0; i < users.length; i++) {

            if (username.equals(users[i].getUsername()) &&
                    password.equals(users[i].getPassword())) {

                System.out.println("\nLogin Successful!");
                System.out.println("Welcome, " + users[i].getRole());

                return users[i].getRole();
            }
        }

        System.out.println("\nInvalid Username or Password.");
        return null;
    }
}
