
import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {

    public static List<Integer> pascalRow(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            list.add(ans);
        }
        return list;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalAns = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            finalAns.add(pascalRow(i));
        }
        return finalAns;
    }

    public static void main(String[] args) {
        System.out.println(generate(6));
    }
}
