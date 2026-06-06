
import java.util.Arrays;

public class bookAllocation {

    public static int studentsRequired(int nums[], int mid) {
        int students = 1;
        int load = 0;

        for (int i = 0; i < nums.length; i++) {
            if (load + nums[i] > mid) {
                students++;
                load = nums[i];
            } else {
                load += nums[i];
            }
        }
        return students;
    }

    public static int capacity(int nums[], int students) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            int m = studentsRequired(nums, mid);

            if (m > students) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }

        }
        return left;
    }

    public static void main(String[] args) {
        int nums[] = {12, 34, 67, 90};
        System.out.println("The min allocation : " + capacity(nums, 2));
    }
}
/* Painter partion problem same as book allocation same as split subarray largest sum

410. Split Array Largest Sum
Hard
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.


Book Allocation Problem
100
Hard
Hint
Given an array nums of n integers, where nums[i] represents the number of pages in the i-th book, and an integer m representing the number of students, allocate all the books to the students so that each student gets at least one book, each book is allocated to only one student, and the allocation is contiguous.



Allocate the books to m students in such a way that the maximum number of pages assigned to a student is minimized. If the allocation of books is not possible, return -1.


Examples:
Input: nums = [12, 34, 67, 90], m=2

Output: 113

Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.

Input: nums = [25, 46, 28, 49, 24], m=4

Output: 71

Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24. */
