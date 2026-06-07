package DP;

public class House_Robber_I {
    
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = nums[0];               // Max money up to 2 houses ago
        int prev1 = Math.max(nums[0], nums[1]); // Max money up to the last house
        
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        System.out.println(rob(arr)); // Output: 4
    }
}

