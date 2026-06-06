//everything appears thrice except one element

public class singleNumberInArray2 {

    public static int singleNumber(int nums[]) {
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;

        }
        return ones;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1, 4, 2, 3, 1, 2, 3};
        System.out.println(singleNumber(nums));
    }
}
