
import java.util.Stack;

public class reverseStack {

    public static void reverse(Stack<Integer> s) {

        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverse(s);
        insertAtBottom(s, top);
    }

    public static void insertAtBottom(Stack<Integer> s, int element) {
        if (s.isEmpty()) {
            s.push(element);
            return;
        }
        int top = s.pop();
        insertAtBottom(s, element);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(8);
        s.push(6);
        s.push(77);
        s.push(22);
        s.push(11);

        System.out.println("Stack before reverse : " + s + "\n");
        reverse(s);
        System.out.println("Stack after reverse : " + s + "\n");
    }
}
