public class DNAAnalyzer {

    // Sequence Length
    public int sequenceLength(String sequence) {

        return sequence.length();

    }

    // GC Content
    public double calculateGCContent(String sequence) {

        int gcCount = 0;

        sequence = sequence.toUpperCase();

        for (int i = 0; i < sequence.length(); i++) {

            char ch = sequence.charAt(i);

            if (ch == 'G' || ch == 'C') {

                gcCount++;

            }

        }

        return ((double) gcCount / sequence.length()) * 100;

    }

    // Complement Sequence
    public String complement(String sequence) {

        sequence = sequence.toUpperCase();

        String result = "";

        for (int i = 0; i < sequence.length(); i++) {

            char ch = sequence.charAt(i);

            if (ch == 'A') {

                result += "T";

            }
            else if (ch == 'T') {

                result += "A";

            }
            else if (ch == 'G') {

                result += "C";

            }
            else if (ch == 'C') {

                result += "G";

            }

        }

        return result;

    }

    // Reverse Complement Sequence
    public String reverseComplement(String sequence) {

        String complement = complement(sequence);

        String reverse = "";

        for (int i = complement.length() - 1; i >= 0; i--) {

            reverse += complement.charAt(i);

        }

        return reverse;

    }

}