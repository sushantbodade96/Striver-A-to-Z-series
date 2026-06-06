
import java.util.*;

class arraysWithGiverXORk {

    public static int countOfSubarraysWithXORK(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int XOR = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            XOR = XOR ^ arr[i];
            if (map.containsKey(XOR ^ k)) {
                count += map.get(XOR ^ k);
            }
            map.put(XOR, map.getOrDefault(XOR, 0) + 1);
        }
        return count;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 2};
        System.out.println("The number of subarrays = " + countOfSubarraysWithXORK(arr, 2));
    }
}
