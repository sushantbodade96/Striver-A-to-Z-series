
public class countSubSeqWithSumK {

    public static int count(int nums[], int index, int requiredsum, int currentSum) {
        if (index == nums.length) {
            if (currentSum == requiredsum) {
                return 1;
            } else {
                return 0;
            }
        }
//pick up element
        currentSum += nums[index];
        int l = count(nums, index + 1, requiredsum, currentSum);

//Not pick up element
        currentSum -= nums[index];
        int r = count(nums, index + 1, requiredsum, currentSum);

        return l + r;

    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 1};
        System.out.println("Total subsequence are : " + count(nums, 0, 2, 0));
    }
}
/*Count all subsequences with sum K


0

100
Easy

Given an array nums and an integer k.Return the number of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.


Examples:
Input : nums = [4, 9, 2, 5, 1] , k = 10

Output : 2

Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].

Input : nums = [4, 2, 10, 5, 1, 3] , k = 5

Output : 3

Explanation : The possible subsets with sum k are [4, 1] , [2, 3] , [5]. */
