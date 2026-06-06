
public class gasStation {

    public static int requiredStations(double dist, int[] stations) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];
            count += (int) (gap / dist);
        }
        return count;
    }

    public static double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double left = 0, right = stations[n - 1] - stations[0];
        double eps = 1e-6; // Precision

        while (right - left > eps) {
            double mid = (left + right) / 2;
            int required = requiredStations(mid, stations);
            if (required > k) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // double ans = 0;
        System.out.printf("The min distance between stations : %.6f\n", minmaxGasDist(nums, 10));
    }
}
/*
 * Minimize Max Distance to Gas Station
100
Hard
Hint
Given a sorted array arr of size n, containing integer positions of n gas stations on the X-axis, and an integer k, place k new gas stations on the X-axis.



The new gas stations can be placed anywhere on the non-negative side of the X-axis, including non-integer positions.



Let dist be the maximum distance between adjacent gas stations after adding the k new gas stations.



Find the minimum value of dist.


Examples:
Input: n = 10, arr = [1, 2, 3, 4, 5, 6 ,7, 8, 9, 10], k = 10

Output: 0.50000

Explanation:

One of the possible ways to place 10 gas stations is [1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10].

Thus the maximum difference between adjacent gas stations is 0.5.

Hence, the value of dist is 0.5.

It can be shown that there is no possible way to add 10 gas stations in such a way that the value of dist is lower than this.

Input : n = 10, arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 1

Output: 1.00000

Explanation:

One of the possible ways to place 1 gas station is [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12].

Thus the maximum difference between adjacent gas stations is still 1.

Hence, the value of dist is 1.

It can be shown that there is no possible way to add 1 gas station in such a way that the value of dist is lower than this. 
 */
