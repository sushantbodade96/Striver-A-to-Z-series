
import java.util.Arrays;

public class moveZeroAtEnd {

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 2, 0, 0, 8};
        System.out.println((String) Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println((String) Arrays.toString(arr));

    }

}
