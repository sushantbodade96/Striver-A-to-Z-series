
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sumOfSubset {

    public static void sums(List<Integer> list, int index, int candidates[], int sum) {
        if (index == candidates.length) {
            list.add(sum);
            return;
        }

        //include current element
        sums(list, index + 1, candidates, sum + candidates[index]);

        //exclude
        sums(list, index + 1, candidates, sum);
    }

    public static List<Integer> allSums(int candidates[]) {
        List<Integer> result = new ArrayList<>();
        sums(result, 0, candidates, 0);
        Collections.sort(result);
        return result;

    }

    public static void main(String[] args) {
        int nums[] = {2, 3};
        System.out.println(allSums(nums));
    }
}
/*Subsets I


0

100
Medium

Given an array nums of n integers.Return sum of all subsets of the array nums.



Output can be printed in any order.


Examples:
Input : nums = [2, 3]

Output : [0, 2, 3, 5]

Explanation :

When no elements is taken then Sum = 0.

When only 2 is taken then Sum = 2.

When only 3 is taken then Sum = 3.

When element 2 and 3 are taken then sum = 2+3 = 5.

Input : nums = [5, 2, 1]

Output : [0, 1, 2, 3, 5, 6, 7, 8]

Explanation :

When no elements is taken then Sum = 0.

When only 5 is taken then Sum = 5.

When only 2 is taken then Sum = 2.

When only 1 is taken then Sum = 1.

When element 2 and 1 are taken then sum = 2+1 = 3. */
