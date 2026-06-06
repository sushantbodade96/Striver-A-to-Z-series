
public class RecursiveAtoi {

    static int atoi(String s) {
        return atoiHelper(s, 0, 0, 1);
    }

    private static int atoiHelper(String s, int index, int result, int sign) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Base case: reached end of string
        if (index == s.length()) {
            return result * sign;
        }

        char ch = s.charAt(index);

        // Handle optional '+' or '-' at start
        if (index == 0 && (ch == '-' || ch == '+')) {
            return atoiHelper(s, index + 1, result, (ch == '-') ? -1 : 1);
        }

        // If non-digit character, stop conversion
        if (ch < '0' || ch > '9') {
            return result * sign;
        }

        // Accumulate result
        result = result * 10 + (ch - '0');

        return atoiHelper(s, index + 1, result, sign);
    }

    public static void main(String[] args) {
        System.out.println(atoi("1234"));     // Output: 1234
        System.out.println(atoi("-567"));     // Output: -567
        System.out.println(atoi("+89"));      // Output: 89
        System.out.println(atoi("42abc"));    // Output: 42
        System.out.println(atoi("abc"));      // Output: 0
    }
}
