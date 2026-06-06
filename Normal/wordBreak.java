
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class wordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict); // Store words for O(1) lookup
        Map<String, Boolean> memo = new HashMap<>(); // Memoization map
        return wb(s, set, memo);
    }

    private static boolean wb(String s, Set<String> set, Map<String, Boolean> memo) {
        if (s.length() == 0) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s); // Return cached result if already computed
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);

            if (set.contains(prefix) && wb(suffix, set, memo)) {
                memo.put(s, true); // Cache result before returning
                return true;
            }
        }

        memo.put(s, false); // Cache negative result
        return false;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s1, wordDict1));
    }
}
