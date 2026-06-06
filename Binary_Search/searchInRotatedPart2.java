
public class searchInRotatedPart2 {

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;

            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                // continue;;
            } else if (nums[mid] >= nums[left]) { //left part is sorted
                if (nums[left] <= target && target <= nums[mid]) { // target lies between left to mid
                    right = mid - 1;
                } else { // target lies between mid to right
                    left = mid + 1;
                }
            } else {// right part is sorted
                if (nums[mid] <= target && target <= nums[right]) {// target lies between mid to right
                    left = mid + 1;
                } else { // target lies between left to mid
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = {2, 5, 6, 0, 0, 1, 2};
        System.out.println("The target 0 is present at index : " + search(nums, 3));
    }
}
