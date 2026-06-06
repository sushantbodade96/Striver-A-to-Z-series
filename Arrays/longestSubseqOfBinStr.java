
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class longestSubseqOfBinStr {

    public static int longestSubsequence(String s, int k) {
        List<Integer> list = new ArrayList<>();
        double sum = 0;
        //int removed = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                list.add(0);
                continue;
            }
            sum = (double) sum + Math.pow(2, n - i - 1);
            if (sum <= k) {
                list.add(1);
            }

        }
        Collections.reverse(list);
        System.out.println(list);
        return list.size();
    }

    public static void main(String[] args) {
        String s = "001010";
        System.out.println(longestSubsequence(s, 5));
    }
}
