
import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning {

    public static boolean isPalindrom(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void helper(String s, int index, List<List<String>> ans, List<String> list) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrom(s, index, i)) {
                list.add(s.substring(index, i + 1));
                helper(s, i + 1, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabb";
        System.out.println(partition(str));
    }
}
/*131. Palindrome Partitioning
Medium
Topics
premium lock icon
Companies
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1,154,950/1.6M
Acceptance Rate
72.4% */
