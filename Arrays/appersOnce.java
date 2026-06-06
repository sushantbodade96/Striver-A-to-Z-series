
public class appersOnce {

    public static int singleNumber(int[] nums) {
        int XOR = 0;
        for (int i = 0; i < nums.length; i++) {
            XOR = XOR ^ nums[i];
        }
        return XOR;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 1, 2, 3, 4, 5, 3, 4};
        System.out.println(singleNumber(arr));
    }

}
