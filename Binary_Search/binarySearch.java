
public class binarySearch {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //int mid = (nums[right] - nums[left])/2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {3, 54, 12, 87, 9, 7, -2};
        System.out.println("The target " + 3 + " is present at index : " + search(nums, 3));
    }

}
