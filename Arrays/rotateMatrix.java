
import java.util.Arrays;

public class rotateMatrix {

    public static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static void reverse(int[][] arr, int r) {
        int m = arr[0].length;
        int left = 0;
        int right = m - 1;

        while (right > left) {
            int temp = arr[r][left];
            arr[r][left] = arr[r][right];
            arr[r][right] = temp;
            right--;
            left++;
        }
    }

    public static void rotate(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = i + 1; j < c; j++) {
                swap(matrix, i, j);
            }
        }

        for (int i = 0; i < r; i++) {
            reverse(matrix, i);
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3, 4},
            {5, 0, 7, 8},
            {0, 10, 11, 12},
            {13, 14, 15, 0}
        };
        rotate(nums);
    }
}
