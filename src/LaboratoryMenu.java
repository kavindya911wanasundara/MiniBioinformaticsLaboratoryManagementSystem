import java.util.Scanner;

public class LaboratoryMenu {

    private SampleManager manager = new SampleManager();
    private DNAAnalyzer analyzer = new DNAAnalyzer();

    public void menu(String role) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== Laboratory Menu =====");
            System.out.println("Logged in as: " + role);
            System.out.println("1. Add DNA Sample");
            System.out.println("2. View DNA Samples");
            System.out.println("3. Analyze DNA Sample");
            System.out.println("4. Update DNA Sample");
            System.out.println("5. Delete DNA Sample");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {

                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Sample ID: ");
                        String id = input.nextLine();

                        System.out.print("Enter Sample Name: ");
                        String name = input.nextLine();

                        System.out.print("Enter Organism: ");
                        String organism = input.nextLine();

                        System.out.print("Enter DNA Sequence: ");
                        String sequence = input.nextLine();

                        DNASample sample = new DNASample(id, name, organism, sequence);
                        manager.addSample(sample);

                        break;

                    case 2:

                        manager.viewSamples();

                        break;

                    case 3:

                        System.out.print("Enter Sample ID: ");
                        String sampleID = input.nextLine();

                        DNASample dna = manager.searchSample(sampleID);

                        if (dna != null) {

                            System.out.println("\n===== DNA Analysis =====");
                            System.out.println("Sequence Length : "
                                    + analyzer.sequenceLength(dna.getDnaSequence()));

                            System.out.printf("GC Content : %.2f%%\n",
                                    analyzer.calculateGCContent(dna.getDnaSequence()));

                            System.out.println("Complement Sequence : "
                                    + analyzer.complement(dna.getDnaSequence()));

                        } else {

                            System.out.println("Sample not found.");

                        }

                        break;

                    case 4:

                        System.out.print("Enter Sample ID: ");
                        sampleID = input.nextLine();

                        System.out.print("Enter New Sample Name: ");
                        name = input.nextLine();

                        System.out.print("Enter New Organism: ");
                        organism = input.nextLine();

                        System.out.print("Enter New DNA Sequence: ");
                        sequence = input.nextLine();

                        if (manager.updateSample(sampleID, name, organism, sequence)) {
                            System.out.println("Sample updated successfully.");
                        } else {
                            System.out.println("Sample not found.");
                        }

                        break;

                    case 5:

                        System.out.print("Enter Sample ID: ");
                        sampleID = input.nextLine();

                        if (manager.deleteSample(sampleID)) {
                            System.out.println("Sample deleted successfully.");
                        } else {
                            System.out.println("Sample not found.");
                        }

                        break;

                    case 6:

                        System.out.println("Logout Successful.");

                        break;

                    default:

                        System.out.println("Invalid Choice.");

                }

            } else {

                System.out.println("Please enter a valid number.");
                input.next();

                choice = 0;
            }

        } while (choice != 6);

    }
}