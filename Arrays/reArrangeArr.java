
//import java.util.ArrayList;
import java.util.Arrays;

public class reArrangeArr {

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        // ArrayList<Integer> Poslist = new ArrayList<>();
        //         ArrayList<Integer> Neglist = new ArrayList<>();

        // for (int i = 0; i < n; i++) {
        //     if(nums[i]>0){
        //         Poslist.add(nums[i]);
        //     }else Neglist.add(nums[i]);
        // }
        int newArray[] = new int[n];
        int pp = 0;
        int np = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                newArray[pp] = nums[i];
                pp += 2;
            } else {
                newArray[np] = nums[i];
                np += 2;
            }
        }

        return newArray;

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, -6, -2, -1, -3};
        // Arrays.toString(arr);

        arr = rearrangeArray(arr);

        System.out.println(Arrays.toString(arr));
    }
}
