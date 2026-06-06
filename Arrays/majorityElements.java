
public class majorityElements {

    public static int majorityElement(int[] nums) {
        int el = nums[0];
        int count = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                n = 1;
                el = nums[i];
                count++;

            } else {
                if (nums[i] == el) {
                    count++;
                } else {
                    count--;
                }
                n++;
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    // public static int majorityElement(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (map.containsKey(nums[i])) {
    //             int newValue = map.get(nums[i]) + 1;
    //             map.put(nums[i], newValue);
    //             if (newValue > nums.length / 2) {
    //                 return nums[i];
    //             }
    //         } else {
    //             map.put(nums[i], 1);
    //         }
    //     }
    //     return -1;
    // }
    public static void main(String[] args) {
        int arr[] = {3, 3, 3, 3, 1, 4, 4};
        System.out.println(majorityElement(arr));
    }
}
