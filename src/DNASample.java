public class DNASample {

    private String sampleID;
    private String sampleName;
    private String organism;
    private String dnaSequence;

    public DNASample(String sampleID, String sampleName, String organism, String dnaSequence) {

        this.sampleID = sampleID;
        this.sampleName = sampleName;
        this.organism = organism;
        setDnaSequence(dnaSequence);

    }

    public String getSampleID() {
        return sampleID;
    }

    public String getSampleName() {
        return sampleName;
    }

    public String getOrganism() {
        return organism;
    }

    public String getDnaSequence() {
        return dnaSequence;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public void setDnaSequence(String dnaSequence) {

        if (dnaSequence.matches("[ATGC]+")) {
            this.dnaSequence = dnaSequence;
        } else {
            System.out.println("Invalid DNA sequence. Only A, T, G and C are allowed.");
            this.dnaSequence = "";
        }

    }

    @Override
    public String toString() {
        return "Sample ID: " + sampleID +
                "\nSample Name: " + sampleName +
                "\nOrganism: " + organism +
                "\nDNA Sequence: " + dnaSequence;
    }
}
