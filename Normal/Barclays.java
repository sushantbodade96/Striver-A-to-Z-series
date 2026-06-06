
import java.util.Arrays;

public class Barclays {

    public static String generateString(String pattern, String constraint) {
        int L1 = pattern.length();
        int L2 = constraint.length();
        int totalLength = L1 + L2 - 1;

        char[] S = new char[totalLength];
        Arrays.fill(S, 'A');

        // Handle Character 'T' first - place required patterns
        for (int i = 0; i < L2; i++) {
            if (constraint.charAt(i) == 'T') {
                for (int j = 0; j < L1; j++) {
                    int pos = i + j;
                    if (pos >= totalLength) {
                        return "-1";
                    }
                    if (S[pos] != 'A' && pattern.charAt(j) != S[pos]) {
                        return "-1"; // Conflict with already placed character
                    }
                    S[pos] = pattern.charAt(j);
                }
            }
        }

        // Handle Character 'F' - ensure pattern doesn't match
        for (int i = 0; i < L2; i++) {
            if (constraint.charAt(i) == 'F') {
                // Check if pattern would match at position i
                boolean wouldMatch = true;
                for (int j = 0; j < L1; j++) {
                    int pos = i + j;
                    if (pos >= totalLength || S[pos] != pattern.charAt(j)) {
                        wouldMatch = false;
                        break;
                    }
                }

                // If it would match, we need to break the match
                if (wouldMatch) {
                    boolean modified = false;
                    // Try to modify a character that won't break existing 'T' constraints
                    for (int j = 0; j < L1; j++) {
                        int pos = i + j;
                        if (pos >= totalLength) {
                            break;
                        }

                        // Check if we can modify this position
                        if (canModifyPosition(pos, S, pattern, constraint, L1, L2)) {
                            // Try different characters
                            for (char newChar = 'A'; newChar <= 'Z'; newChar++) {
                                if (newChar != pattern.charAt(j)) {
                                    S[pos] = newChar;
                                    if (isValidWithModification(S, pattern, constraint, L1, L2)) {
                                        modified = true;
                                        break;
                                    }
                                }
                            }
                            if (modified) {
                                break;
                            }
                        }
                    }
                    if (!modified) {
                        return "-1";
                    }
                }
            }
        }

        // Final validation
        return isValidSolution(S, pattern, constraint, L1, L2) ? new String(S) : "-1";
    }

    private static boolean canModifyPosition(int pos, char[] S, String pattern, String constraint, int L1, int L2) {
        // Check if modifying this position would break any 'T' constraint
        for (int i = 0; i < L2; i++) {
            if (constraint.charAt(i) == 'T') {
                int patternStart = i;
                int patternEnd = i + L1 - 1;
                if (pos >= patternStart && pos <= patternEnd) {
                    return false; // This position is part of a required pattern match
                }
            }
        }
        return true;
    }

    private static boolean isValidWithModification(char[] S, String pattern, String constraint, int L1, int L2) {
        // Quick check if current state is valid
        for (int i = 0; i < L2; i++) {
            if (constraint.charAt(i) == 'T') {
                for (int j = 0; j < L1; j++) {
                    int pos = i + j;
                    if (pos >= S.length || S[pos] != pattern.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidSolution(char[] S, String pattern, String constraint, int L1, int L2) {
        for (int i = 0; i < L2; i++) {
            boolean matches = true;
            for (int j = 0; j < L1; j++) {
                int pos = i + j;
                if (pos >= S.length || S[pos] != pattern.charAt(j)) {
                    matches = false;
                    break;
                }
            }

            if (constraint.charAt(i) == 'T' && !matches) {
                return false; // Should match but doesn't
            }
            if (constraint.charAt(i) == 'F' && matches) {
                return false; // Shouldn't match but does
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "ABCA";
        String constraint = "TFFF";
        System.out.println(generateString(pattern, constraint));

        // Test with more examples
        System.out.println(generateString("AB", "TF")); // Should work
        System.out.println(generateString("ABC", "TFF")); // Should work
    }
}
