//Every number appears twice except one

public class singleNumberInArray {

    public static int singleNumber(int nums[]) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 3, 4, 1};
        System.out.println(singleNumber(nums));
    }
}
