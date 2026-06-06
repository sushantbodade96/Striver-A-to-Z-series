
class medOfArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //double med;
        int arr[] = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
                k++;
            } else {
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }
        if (i == nums1.length) {
            while (j < nums2.length) {
                arr[k] = nums2[j];
                k++;
                j++;
            }
        } else {
            while (i < nums1.length) {
                arr[k] = nums1[i];
                k++;
                i++;
            }

        }
        for (int n = 0; n < arr.length; n++) {
            System.out.print(arr[n] + " ");
        }
        if (arr.length % 2 != 0) {
            return (double) arr[arr.length / 2];
        }
        return (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;

    }

    public static void main(String[] args) {
        int arr1[] = {1, 2};
        int arr2[] = {3, 4};
        double res = findMedianSortedArrays(arr1, arr2);
        System.out.println(res);
    }
}
