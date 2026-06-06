
import java.util.Arrays;
import java.util.PriorityQueue;

public class serverTasks {

    public static int[] userServers(int tasks[], int servers[]) {
        PriorityQueue<int[]> availableServer = new PriorityQueue<>((a, b) -> (a[1] != b[1]) ? (a[1] - b[1]) : (a[0] - b[0]));
        for (int i = 0; i < servers.length; i++) {
            availableServer.add(new int[]{i, servers[i]});
        }

        PriorityQueue<int[]> processingServer = new PriorityQueue<>(
                (a, b)
                -> (a[2] != b[2]) ? (a[2] - b[2])
                        : (a[1] != b[1]) ? (a[1] - b[1])
                                : (a[0] - b[0])
        );

        int result[] = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            while (!processingServer.isEmpty() && processingServer.peek()[2] <= i) {
                int serverIndex = processingServer.remove()[0];
                availableServer.add(new int[]{serverIndex, servers[serverIndex]});
            }
            int server[];
            int freeTime = tasks[i];

            if (!availableServer.isEmpty()) {
                server = availableServer.remove();
                freeTime += i;
            } else {
                server = processingServer.remove();
                freeTime += server[2];
            }
            int serverIndex = server[0];
            processingServer.add(new int[]{serverIndex, servers[serverIndex], freeTime});
            result[i] = (serverIndex);
        }
        return result;
    }

    public static void main(String[] args) {
        int servers[] = {3, 3, 2};
        int tasks[] = {1, 2, 3, 2, 1, 2};
        System.out.println(Arrays.toString(userServers(tasks, servers)));
    }
}
