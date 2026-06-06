
public class Height_Balanced_Tree {

    static class Node {

        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isBalanced(Node root) {
        return height(root) != -1;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = height(root.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(rh - lh) > 1) {
            return -1;
        }
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(2);
        root.left.left.left = new Node(2);
        //  root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(3);
        root.right.right.right = new Node(3);
        System.out.println(isBalanced(root));
    }
}
