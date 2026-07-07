import java.util.Scanner;

public class LaboratoryMenu {

    SampleManager manager = new SampleManager();
    DNAAnalyzer analyzer = new DNAAnalyzer();

    public void menu(String role) {

        if (role.equals("Admin")) {

            adminMenu();

        } else if (role.equals("Technician")) {

            technicianMenu();

        } else if (role.equals("Researcher")) {

            researcherMenu();

        }

    }

    // -------------------- ADMIN MENU --------------------

    public void adminMenu() {

        Scanner input = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. View DNA Samples");
            System.out.println("2. Logout");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    manager.viewSamples();

                    break;

                case 2:

                    System.out.println("Logout Successful.");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 2);

    }

    // -------------------- TECHNICIAN MENU --------------------

    public void technicianMenu() {

        Scanner input = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== LABORATORY TECHNICIAN MENU =====");
            System.out.println("1. Add DNA Sample");
            System.out.println("2. View DNA Samples");
            System.out.println("3. Logout");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Sample ID : ");
                    String id = input.nextLine();

                    System.out.print("Enter Sample Name : ");
                    String name = input.nextLine();

                    System.out.print("Enter Organism : ");
                    String organism = input.nextLine();

                    System.out.print("Enter DNA Sequence : ");
                    String sequence = input.nextLine();

                    DNASample sample = new DNASample(id, name, organism, sequence);

                    manager.addSample(sample);

                    break;

                case 2:

                    manager.viewSamples();

                    break;

                case 3:

                    System.out.println("Logout Successful.");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 3);

    }

    // -------------------- RESEARCHER MENU --------------------

    public void researcherMenu() {

        Scanner input = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== RESEARCHER MENU =====");
            System.out.println("1. View DNA Samples");
            System.out.println("2. Analyze DNA Sample");
            System.out.println("3. Logout");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    manager.viewSamples();

                    break;

                case 2:

                    System.out.print("Enter Sample ID : ");
                    String sampleID = input.nextLine();

                    DNASample dna = manager.searchSample(sampleID);

                    if (dna != null) {

                        System.out.println("Sequence Length : "
                                + analyzer.sequenceLength(dna.getDnaSequence()));

                        System.out.println("GC Content : "
                                + analyzer.calculateGCContent(dna.getDnaSequence()));

                        System.out.println("Complement Sequence : "
                                + analyzer.complement(dna.getDnaSequence()));

                    } else {

                        System.out.println("Sample not found.");

                    }

                    break;

                case 3:

                    System.out.println("Logout Successful.");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 3);

    }

}