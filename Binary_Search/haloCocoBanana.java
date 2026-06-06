
import java.util.Arrays;
//import java.util.Collections;

public class haloCocoBanana {

    public static int totalHr(int pile[], int mid) {
        int totalHr = 0;
        for (int i = 0; i < pile.length; i++) {
            totalHr += Math.ceil((double) pile[i] / mid);
        }
        return totalHr;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int ans = 1;
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            int totalHr = totalHr(piles, mid);
            if (totalHr <= h) {
                ans = mid;
                right = mid - 1;

            } else {
                left = mid + 1;

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {30, 11, 23, 4, 20};
        System.out.println("The number of bananas coco will eat per hour is : " + minEatingSpeed(nums, 6));
    }
}
