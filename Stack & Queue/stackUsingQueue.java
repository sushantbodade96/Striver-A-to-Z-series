
import java.util.*;

public class stackUsingQueue {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public stackUsingQueue() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int element) {
        q2.offer(element);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        // return false;
    }

    public int top() {
        return q1.peek();
    }

    public int pop() {
        return q1.poll();
    }

    public static void main(String[] args) {
        stackUsingQueue stack = new stackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.top());

    }

}
