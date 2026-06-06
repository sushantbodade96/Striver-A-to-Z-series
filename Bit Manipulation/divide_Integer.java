
public class divide_Integer {

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Handle overflow
        }
        boolean isPositive = (dividend < 0) == (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;

        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }

        result = isPositive ? result : -result;
        return (int) result;
    }

    public static void main(String[] args) {
        divide_Integer sol = new divide_Integer();

        int dividend1 = 10, divisor1 = 3;
        int result1 = sol.divide(dividend1, divisor1);
        System.out.println(dividend1 + " / " + divisor1 + " = " + result1); // Output: 3

        int dividend2 = 7, divisor2 = -3;
        int result2 = sol.divide(dividend2, divisor2);
        System.out.println(dividend2 + " / " + divisor2 + " = " + result2); // Output: -2

        int dividend3 = Integer.MIN_VALUE, divisor3 = -1;
        int result3 = sol.divide(dividend3, divisor3);
        System.out.println(dividend3 + " / " + divisor3 + " = " + result3); // Output: 2147483647 (overflow handled)

        int dividend4 = 0, divisor4 = 1;
        int result4 = sol.divide(dividend4, divisor4);
        System.out.println(dividend4 + " / " + divisor4 + " = " + result4); // Output: 0

        int dividend5 = -10, divisor5 = -2;
        int result5 = sol.divide(dividend5, divisor5);
        System.out.println(dividend5 + " / " + divisor5 + " = " + result5); // Output: 5
    }
}
/*29. Divide Two Integers
Solved
Medium
Topics
premium lock icon
Companies
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0 */
