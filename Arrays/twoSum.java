
import java.util.HashMap;

public class twoSum {

    public static int[] twoSumm(int[] nums, int target) {
        int arr[] = new int[2];
        //int sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // sum = nums[i];wwwwwwwwwwww 
            int req = target - nums[i];
            if (map.containsKey(req)) {
                int j = map.get(req);
                arr[0] = j;
                arr[1] = i;
                return arr;
            }
            map.put(nums[i], i);
        }
        return arr;

    }

    // public static int[] twoSum(int[] nums, int target) {
    //     int arr[] = new int[2];
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             int sum = nums[i];
    //             sum += nums[j];
    //             if (sum == target) {
    //                 arr[0] = i;
    //                 arr[1] = j;
    //                 return arr;
    //             }
    //         }
    //     }
    //     return arr;
    // }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 0, 4, 9, 11};
        int k[] = twoSumm(arr, 7);
        System.out.println(k[0] + " " + k[1]);

    }

}
