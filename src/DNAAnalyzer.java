public class DNAAnalyzer {

    public int sequenceLength(String sequence) {

        return sequence.length();

    }

    public double calculateGCContent(String sequence) {

        int gcCount = 0;

        for (int i = 0; i < sequence.length(); i++) {

            char ch = sequence.charAt(i);

            if (ch == 'G' || ch == 'C') {

                gcCount++;

            }

        }

        return ((double) gcCount / sequence.length()) * 100;

    }

    public String complement(String sequence) {

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

}