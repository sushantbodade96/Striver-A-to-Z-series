
public class repeatingAndMissing {

    public static void Rep_Miss(int nums[]) {
        // int n = nums.length;
        // int missing = -1;
        // int repeating = -1;
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 1; i <= n; i++) {
        //     map.put(i, 0);
        // }
        // for (int i = 0; i < n; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }
        // for (int key : map.keySet()) {
        //     if (map.get(key) == 0) {
        //         missing = key;
        //     }
        //     if (map.get(key) > 1) {
        //         repeating = key;
        //     }
        // }
        // System.out.println("Repeating :" + repeating + " Missing : " + missing);

        int n = nums.length;
        long sn = (n * (n + 1)) / 2;
        long sn2 = (n * (n + 1) * (2 * n + 1)) / 6;
        long s = 0;
        long s2 = 0;

        for (int i = 0; i < n; i++) {
            s += nums[i];
            s2 += nums[i] * nums[i];
        }
        long eq1 = s - sn;
        long eq2 = (s2 - sn2) / eq1;
        long repeating = (eq1 + eq2) / 2;
        long missing = repeating - eq1;
        System.out.println("repeating : " + repeating + " missing : " + missing);
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 3, 5, 6};
        Rep_Miss(nums);
    }
}
