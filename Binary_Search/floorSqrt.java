
public class floorSqrt {

    public static int sqrt(int k) {
        int left = 1;
        int right = k;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (mid * mid <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;

    }

    public static void main(String[] args) {
        System.out.println("The floor of sqrt of 28 is " + sqrt(28));
    }
}
