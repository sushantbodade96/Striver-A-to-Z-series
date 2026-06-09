/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
*/

package DP;

public class Climbing_Stairs {
    public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int prev1 = 2;
        int prev2 = 1;
        int curr = 0;
        for(int i=0 ; i < (n-2) ; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
        
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }
}


/*DP Solution
package DP;

public class House_Robber_I {
    
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        // Create a 1D DP array to store the max money stashed up to house i
        int[] dp = new int[nums.length];
        
        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        // Fill the 1D array
        for (int i = 2; i < nums.length; i++) {
            // Decision: Rob current house + max from 2 houses ago OR skip current house
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        // The last element contains the maximum money that can be robbed
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        System.out.println(rob(arr)); // Output: 4
    }
}
*/