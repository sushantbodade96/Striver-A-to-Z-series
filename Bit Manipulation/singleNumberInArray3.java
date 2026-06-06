//everyone appears twice but 2 elements appear once

import java.util.ArrayList;
import java.util.Arrays;

public class singleNumberInArray3 {

    public static ArrayList<Integer> TwoSingleNumbers(int nums[]) {
        int XOR = 0;
        for (int i = 0; i < nums.length; i++) {
            XOR = XOR ^ nums[i];
        }
        int rightMost = (XOR & (XOR - 1)) ^ XOR;
        int b1 = 0, b2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightMost) != 0) {
                b1 ^= nums[i];
            } else {
                b2 ^= nums[i];
            }
        }
        return new ArrayList(Arrays.asList(b1, b2));
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1, 2, 3, 4, 35};
        System.out.println(TwoSingleNumbers(nums));
    }
}
