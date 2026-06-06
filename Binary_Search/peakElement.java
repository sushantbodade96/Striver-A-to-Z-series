//Imagine a mountain mid can be on ascending part or descending part , eliminate the unnecessary part

public class peakElement {

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        } else if (nums[0] > nums[1]) {
            return 0;
        } else if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int mid;
        int left = 1;
        int right = n - 2;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid]) {
                left = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return - 1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("The peak element is at index : " + findPeakElement(nums));
    }
}
