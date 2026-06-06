
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinationOfAPhoneNumber {

    public static void helper(int index, List<String> ans, String digits, Map<Character, String> map, StringBuilder newStr) {
        if (index == digits.length()) {
            ans.add(newStr.toString());
            return;
        }

        String str = map.get(digits.charAt(index));

        for (int j = 0; j < str.length(); j++) {
            newStr.append(str.charAt(j));
            helper(index + 1, ans, digits, map, newStr);
            newStr.deleteCharAt(newStr.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(0, ans, digits, map, new StringBuilder());
        return ans;
    }

    public static void main(String[] args) {
        String str = "";
        System.out.println(letterCombinations(str));
    }
}
/*17. Letter Combinations of a Phone Number
Medium
Topics
premium lock icon
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']. */
