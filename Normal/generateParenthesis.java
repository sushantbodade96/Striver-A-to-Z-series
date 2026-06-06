
import java.util.ArrayList;

public class generateParenthesis {

    public static ArrayList<String> generate(int n) {
        ArrayList<String> list = new ArrayList<>();
        helper(list, 0, 0, n, "");
        return list;
    }

    public static void helper(ArrayList<String> list, int open, int close, int max, String result) {
        if (result.length() == 2 * max) {
            list.add(result);
        }
        if (open < max) {
            helper(list, open + 1, close, max, result + "(");
        }
        if (close < open) {
            helper(list, open, close + 1, max, result + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}
