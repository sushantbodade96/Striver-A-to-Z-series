
import java.util.Stack;

public class sortStaxkRecursively {

    public static void sortStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        sortStack(s);
        insertInOrder(s, top);
    }

    public static void insertInOrder(Stack<Integer> s, int element) {
        if (s.isEmpty() || s.peek() <= element) {
            s.push(element);
            return;
        }

        int top = s.pop();
        insertInOrder(s, element);
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

        System.out.println("Stack before sorting : " + s + "\n");
        sortStack(s);
        System.out.println("Stack after sorting : " + s + "\n");
    }

}
