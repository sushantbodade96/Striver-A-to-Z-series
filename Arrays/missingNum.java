
public class missingNum {

    public static int missingNumber(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {0, 2, 3, 1};
        System.out.println((int) missingNumber(arr));
    }

}
