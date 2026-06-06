
import java.util.Arrays;

public class andArrayGenerator {

    public static int[] generate(int nums[], int k) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] & k;
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(generate(nums, 3)));
    }
}
