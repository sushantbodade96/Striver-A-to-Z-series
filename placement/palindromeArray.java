
import java.util.Arrays;

public class palindromeArray {

    public static String[] PalindromeArray(int nums[]) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                str[i] = "No";
                continue;
            }
            if (isPalindrome(nums[i])) {
                str[i] = "Yes";
            } else {
                str[i] = "No";
            }
        }
        return str;
    }

    public static boolean isPalindrome(int n) {
        int original = n;
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        int nums[] = {121, -13, 17, 987789, 98};
        String s[] = PalindromeArray(nums);
        System.out.println(Arrays.toString(s));
    }
}
