/*
Example 1:
Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]
Output: 210
Explanation:
Day 1: fighting practice = 70
Day 2: stealth training = 50
Day 3: fighting practice = 90
Total = 70 + 50 + 90 = 210
This gives the optimal points.

Example 2:
Input: matrix = [[70, 40, 10], [180, 20, 5], [200, 60, 30]]
Output: 290 
Explanation:
Day 1: running = 70
Day 2: stealth training = 20
Day 3: running = 200
Total = 70 + 20 + 200 = 290
This gives the optimal points. */
package DP;

import java.util.Arrays;

public class Ninja_Training {
    
    // day: current day we are evaluating (moving from N-1 down to 0)
    // lastActivity: the activity chosen on day + 1 (0: Running, 1: Stealth, 2: Fighting, 3: None/Start)
    public static int maxPoint(int matrix[][], int day, int lastActivity, int dp[][]) {
        // Base case: If we reach Day 0, choose the max point activity that isn't lastActivity
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != lastActivity) {
                    max = Math.max(max, matrix[0][i]);
                }
            }
            return max;
        }
        
        // Return cached result if already calculated
        if (dp[day][lastActivity] != -1) {
            return dp[day][lastActivity];
        }
        
        int maxPoints = 0;
        
        // Loop through all 3 possible activities for the current day
        for (int i = 0; i < 3; i++) {
            if (i != lastActivity) {
                // Points gained today + optimal points from previous days
                int points = matrix[day][i] + maxPoint(matrix, day - 1, i, dp);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        
        // Memoize and return
        return dp[day][lastActivity] = maxPoints;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {10, 40, 70}, 
            {20, 50, 80}, 
            {30, 60, 90}
        };
        
        int n = matrix.length;
        // dp table size: [days][4] 
        // 4 columns because lastActivity can be 0, 1, 2, or 3 (initial state)
        int dp[][] = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // Start from the last day (n-1) with an initial lastActivity of 3 (no restriction)
        System.out.println(maxPoint(matrix, n - 1, 3, dp)); // Output: 210
    }
}