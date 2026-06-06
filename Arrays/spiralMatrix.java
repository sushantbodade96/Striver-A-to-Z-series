
import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;

        }

        return list;
    }

    public static void main(String[] args) {
        // int[][] nums = {
        //     {1, 2, 3, 4},
        //     {12, 13, 14, 5},
        //     {11, 16, 15, 6},
        //     {10, 9, 8, 7}
        // };

        int[][] nums = {
            {6, 9, 7}

        };
        System.out.println(spiralOrder(nums));
    }
}
