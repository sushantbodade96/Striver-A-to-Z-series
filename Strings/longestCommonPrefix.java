
public class longestCommonPrefix {

    public static String LongestCommonPrefix(String[] strs) {
        //String ans = "";
        int n = strs.length;
        String pref = strs[0];
        int prefLength = pref.length();

        for (int i = 1; i < n; i++) {
            while (prefLength > strs[i].length() || !pref.equals(strs[i].substring(0, prefLength))) {
                prefLength--;
                if (prefLength == 0) {
                    return "";
                }
                pref = pref.substring(0, prefLength);

            }
        }
        return pref;

    }

    public static void main(String[] args) {
        String nums[] = {"flower", "flow", "flight"};
        System.out.println("The longest common prefix is : " + LongestCommonPrefix(nums));
    }
}
/*14. Longest Common Prefix
Easy
Topics
premium lock icon
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty. */
