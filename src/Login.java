import java.util.Scanner;

public class Login {

    User admin = new User("admin", "admin123", "Admin");
    User tech = new User("tech", "tech123", "Technician");
    User research = new User("research", "research123", "Researcher");

    public String login() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            System.out.println("Login Successful.");
            return admin.getRole();
        }

        if (username.equals(tech.getUsername()) && password.equals(tech.getPassword())) {
            System.out.println("Login Successful.");
            return tech.getRole();
        }

        if (username.equals(research.getUsername()) && password.equals(research.getPassword())) {
            System.out.println("Login Successful.");
            return research.getRole();
        }

        System.out.println("Invalid Username or Password.");
        return null;
    }
}