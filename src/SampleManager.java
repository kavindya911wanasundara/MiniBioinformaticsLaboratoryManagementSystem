public class SampleManager {

    DNASample[] samples = new DNASample[10];
    int count = 0;

    // Check whether DNA sequence is valid
    public boolean isValidDNA(String sequence) {

        sequence = sequence.toUpperCase();

        for (int i = 0; i < sequence.length(); i++) {

            char ch = sequence.charAt(i);

            if (ch != 'A' && ch != 'T' && ch != 'G' && ch != 'C') {

                return false;

            }

        }

        return true;

    }

    // Add Sample
    public void addSample(DNASample sample) {

        if (!isValidDNA(sample.getDnaSequence())) {

            System.out.println("Invalid DNA Sequence.");
            System.out.println("Only A, T, G and C are allowed.");
            return;

        }

        if (count < samples.length) {

            samples[count] = sample;
            count++;
            System.out.println("Sample added successfully.");

        } else {

            System.out.println("Storage is full.");

        }

    }

    // View Samples
    public void viewSamples() {

        if (count == 0) {

            System.out.println("No samples available.");

        } else {

            for (int i = 0; i < count; i++) {

                System.out.println("-----------------------------");
                System.out.println("Sample ID : " + samples[i].getSampleID());
                System.out.println("Sample Name : " + samples[i].getSampleName());
                System.out.println("Organism : " + samples[i].getOrganism());
                System.out.println("DNA Sequence : " + samples[i].getDnaSequence());

            }

        }

    }

    // Search Sample
    public DNASample searchSample(String sampleID) {

        for (int i = 0; i < count; i++) {

            if (samples[i].getSampleID().equals(sampleID)) {

                return samples[i];

            }

        }

        return null;

    }

    // Update Sample
    public void updateSample(String sampleID, String newName, String newOrganism, String newSequence) {

        DNASample sample = searchSample(sampleID);

        if (sample != null) {

            if (!isValidDNA(newSequence)) {

                System.out.println("Invalid DNA Sequence.");
                System.out.println("Only A, T, G and C are allowed.");
                return;

            }

            sample.setSampleName(newName);
            sample.setOrganism(newOrganism);
            sample.setDnaSequence(newSequence);

            System.out.println("Sample updated successfully.");

        } else {

            System.out.println("Sample not found.");

        }

    }

    // Delete Sample
    public void deleteSample(String sampleID) {

        for (int i = 0; i < count; i++) {

            if (samples[i].getSampleID().equals(sampleID)) {

                for (int j = i; j < count - 1; j++) {

                    samples[j] = samples[j + 1];

                }

                samples[count - 1] = null;
                count--;

                System.out.println("Sample deleted successfully.");
                return;

            }

        }

        System.out.println("Sample not found.");

    }

}