
import java.util.Arrays;

public class minShipCapacity {

    public static int daysRequired(int weight[], int capacity) {
        int load = 0;
        int days = 1;
        for (int i = 0; i < weight.length; i++) {
            if (load + weight[i] > capacity) {
                days++;
                load = weight[i];
            } else {
                load += weight[i];
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        // int left = 1;
        // int right = 500;
        int left = Arrays.stream(weights).max().getAsInt();
        int right = 25000000;

        int mid;
        while (left <= right) {
            mid = (right + left) / 2;

            int daysNeeded = daysRequired(weights, mid);

            if (daysNeeded > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int weight[] = {1, 2, 3, 1, 1};
        System.out.println("Min capacity required : " + shipWithinDays(weight, 4));
    }
}
