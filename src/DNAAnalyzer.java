public class DNAAnalyzer {

    public int sequenceLength(String sequence) {

        if (sequence == null || sequence.isEmpty()) {
            return 0;
        }

        return sequence.length();

    }

    public double calculateGCContent(String sequence) {

        if (sequence == null || sequence.isEmpty()) {
            return 0;
        }

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

    public String complement(String sequence) {

        if (sequence == null || sequence.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        sequence = sequence.toUpperCase();

        for (int i = 0; i < sequence.length(); i++) {

            char ch = sequence.charAt(i);

            switch (ch) {

                case 'A':
                    result.append('T');
                    break;

                case 'T':
                    result.append('A');
                    break;

                case 'G':
                    result.append('C');
                    break;

                case 'C':
                    result.append('G');
                    break;

                default:
                    result.append(ch);

            }

        }

        return result.toString();

    }

}