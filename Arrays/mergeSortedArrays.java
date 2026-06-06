
import java.util.Arrays;

public class mergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++, i++) {
            nums1[i] = nums2[j];
            //i++;
        }
        Arrays.sort(nums1);

    }

    public static void main(String[] args) {
        int nums1[] = {3, 6, 1, 8, 0, 0, 0, 0, 0};
        int nums2[] = {2, 4, 11, 7, 8};
        merge(nums1, 4, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }

}
