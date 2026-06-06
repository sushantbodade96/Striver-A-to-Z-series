
import java.util.HashMap;

public class luckyInteger {

    public static int findLucky(int[] arr) {
        int n = arr.length;
        //  int lucky = -1;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        int prev = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == freq.get(arr[i]) && arr[i] > prev) {
                prev = arr[i];
                // lucky = arr[i];
            }
        }

        return prev;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 3, 3, 3};
        System.out.println("The lucky number is : " + findLucky(nums));
    }
}
