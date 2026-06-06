
import java.util.HashMap;

public class longestSubstring {

    public static int maxlength(String s) {
        int maxlength = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }
            map.put(ch, right);
            maxlength = Math.max(maxlength, right - left + 1);
        }
        return maxlength;
    }

    public static void main(String[] args) {
        String input = "abcybcae";
        System.out.println("Length of longest substring: " + maxlength(input));
    }
}
