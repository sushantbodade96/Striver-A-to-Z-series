
public class wordSearch {

    public static boolean search(int i, int j, int index, String word, int n, int m, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i == n || j == m || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';

        Boolean op1 = search(i + 1, j, index + 1, word, n, m, board);
        Boolean op2 = search(i - 1, j, index + 1, word, n, m, board);

        Boolean op3 = search(i, j + 1, index + 1, word, n, m, board);

        Boolean op4 = search(i, j - 1, index + 1, word, n, m, board);

        board[i][j] = temp;

        return op1 || op2 || op3 || op4;

    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(i, j, 0, word, board.length, board[0].length, board)) {
                    return true;
                };
            }
        }
        return false;
    }

    public static void main(String[] args) {
        wordSearch ws = new wordSearch();

        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        System.out.println(ws.exist(board, "ABCCED")); // true
        System.out.println(ws.exist(board, "SEE"));    // true
        System.out.println(ws.exist(board, "ABCB"));   // false
    }

}
/*79. Word Search
Medium
Topics
premium lock icon
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board? */
