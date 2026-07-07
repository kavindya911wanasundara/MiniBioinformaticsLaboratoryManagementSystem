public class SampleManager {

    DNASample[] samples = new DNASample[10];
    int count = 0;

    public void addSample(DNASample sample){

        if(count < samples.length){
            samples[count] = sample;
            count++;
            System.out.println("Sample added successfully.");
        }
        else{
            System.out.println("Storage is full.");
        }

    }

    public void viewSamples(){

        if(count == 0){
            System.out.println("No samples available.");
        }
        else{

            for(int i=0; i<count; i++){

                System.out.println("---------------------");
                System.out.println("Sample ID : " + samples[i].getSampleID());
                System.out.println("Sample Name : " + samples[i].getSampleName());
                System.out.println("Organism : " + samples[i].getOrganism());
                System.out.println("DNA Sequence : " + samples[i].getDnaSequence());

            }

        }

    }

    public DNASample searchSample(String sampleID){

        for(int i=0; i<count; i++){

            if(samples[i].getSampleID().equals(sampleID)){
                return samples[i];
            }

        }

        return null;

    }

}