public class SampleManager {

    private DNASample[] samples = new DNASample[10];
    private int count = 0;

    public void addSample(DNASample sample) {

        if (count < samples.length) {
            samples[count] = sample;
            count++;
            System.out.println("Sample added successfully.");
        } else {
            System.out.println("Storage is full.");
        }

    }

    public void viewSamples() {

        if (count == 0) {
            System.out.println("No samples available.");
        } else {

            System.out.println("\n===== DNA Sample List =====");

            for (int i = 0; i < count; i++) {

                System.out.println("-------------------------");
                System.out.println(samples[i]);

            }

        }

    }

    public DNASample searchSample(String sampleID) {

        for (int i = 0; i < count; i++) {

            if (samples[i].getSampleID().equalsIgnoreCase(sampleID)) {
                return samples[i];
            }

        }

        return null;

    }

    public boolean deleteSample(String sampleID) {

        for (int i = 0; i < count; i++) {

            if (samples[i].getSampleID().equalsIgnoreCase(sampleID)) {

                for (int j = i; j < count - 1; j++) {
                    samples[j] = samples[j + 1];
                }

                samples[count - 1] = null;
                count--;

                return true;
            }

        }

        return false;

    }

    public boolean updateSample(String sampleID, String name, String organism, String sequence) {

        DNASample sample = searchSample(sampleID);

        if (sample != null) {

            sample.setSampleName(name);
            sample.setOrganism(organism);
            sample.setDnaSequence(sequence);

            return true;
        }

        return false;

    }

}
