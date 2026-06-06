
public class isArraySorted {

    public static boolean check(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                flag++;
            }
            if (nums[0] < nums[nums.length - 1] && flag == 1) {
                return false;
            }
            if (flag > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 3, 2};
        System.out.println(check(arr));
    }

}
