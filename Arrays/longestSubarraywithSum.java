
public class longestSubarraywithSum {

    public static int longestLength(int arr[], int sum) {
        int longestLength = 0;
        int left = 0;
        int right = 0;
        int k = arr[0];
        while (right < arr.length) {

            while (k > sum) {
                k = k - arr[left];
                left++;
            }
            if (k == sum) {
                longestLength = Math.max(longestLength, right - left + 1);
            }
            right++;
            if (right >= arr.length) {
                break;
            }
            k += arr[right];

        }

        return longestLength;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 2, 3, 3, 6, 5, 1};
        System.out.println((int) longestLength(arr, 6));
    }
}
