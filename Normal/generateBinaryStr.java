
import java.util.*;

public class generateBinaryStr {

    public List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        generate(n, "", false, result);
        return result;
    }

    // Recursive helper function
    private void generate(int n, String current, boolean lastWasOne, List<String> result) {
        if (n == 0) {
            result.add(current);
            return;
        }

        // You can always add '0'
        generate(n - 1, current + "0", false, result);

        // You can only add '1' if last character was not '1'
        if (!lastWasOne) {
            generate(n - 1, current + "1", true, result);
        }
    }

    public static void main(String[] args) {
        generateBinaryStr s = new generateBinaryStr();
        System.out.println(s.generateBinaryStrings(3)); // Output: ["000", "001", "010", "100", "101"]
        System.out.println(s.generateBinaryStrings(2)); // Output: ["00", "01", "10"]

    }

}
/*
 * Generate Binary Strings Without Consecutive 1s


0

100
Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.



A binary string is a string consisting only of characters '0' and '1'.


Examples:
Input: n = 3

Output: ["000", "001", "010", "100", "101"]

Explanation: All strings are of length 3 and do not contain consecutive 1s.

Input: n = 2

Output: ["00", "01", "10"]
 */
