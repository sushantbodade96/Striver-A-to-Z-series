
public class minInRotatedSorted {

    //identify sorted part and consider its minimun and eliminate sorted part
    public static int search(int nums[]) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;

            if (nums[left] <= nums[mid]) {
                min = Math.min(nums[left], min);
                left = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                right = mid - 1;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        int nums[] = {3, 4, 5, 1, 2};
        System.out.println("The minimum element in given array is : " + search(nums));
    }
}
