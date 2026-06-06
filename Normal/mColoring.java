
public class mColoring {

    public static boolean graphColoring(int[][] edges, int m, int n) {
        int[] color = new int[n]; // color[i] = color assigned to vertex i
        return solve(0, edges, color, m, n);
    }

    private static boolean solve(int node, int[][] edges, int[] color, int m, int n) {
        if (node == n) {
            return true; // All nodes successfully colored
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, edges, color, c, n)) {
                color[node] = c; // Assign color c to node
                if (solve(node + 1, edges, color, m, n)) {
                    return true; // Success
                }
                color[node] = 0; // Backtrack
            }
        }

        return false; // No valid color found
    }

    private static boolean isSafe(int node, int[][] edges, int[] color, int c, int n) {
        for (int i = 0; i < n; i++) {
            if (edges[node][i] == 1 && color[i] == c) {
                return false; // Adjacent node has same color
            }
        }
        return true;
    }

    // Sample test
    public static void main(String[] args) {
        int N1 = 4;
        int M1 = 3;
        int[][] edges1 = new int[N1][N1];

        int[][] inputEdges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}};
        for (int[] e : inputEdges1) {
            edges1[e[0]][e[1]] = 1;
            edges1[e[1]][e[0]] = 1; // Undirected graph
        }
        System.out.println("Output 1: " + graphColoring(edges1, M1, N1)); // true

        int N2 = 3;
        int M2 = 2;
        int[][] edges2 = new int[N2][N2];
        int[][] inputEdges2 = {{0, 1}, {1, 2}, {0, 2}};
        for (int[] e : inputEdges2) {
            edges2[e[0]][e[1]] = 1;
            edges2[e[1]][e[0]] = 1;
        }
        System.out.println("Output 2: " + graphColoring(edges2, M2, N2)); // false
    }
}
/*
M Coloring Problem


0

100
Hard

Given an integer M and an undirected graph with N vertices and E edges. The goal is to determine whether the graph can be coloured with a maximum of M colors so that no two of its adjacent vertices have the same colour applied to them.



In this context, colouring a graph refers to giving each vertex a different colour. If the colouring of vertices is possible then return true, otherwise return false.


Examples:
Input : N = 4 , M = 3 , E = 5 , Edges = [ (0, 1) , (1, 2) , (2, 3) , (3, 0) , (0, 2) ]

Output : true

Explanation : Consider the three colors to be red, green, blue.

We can color the vertex 0 with red, vertex 1 with blue, vertex 2 with green, vertex 3 with blue.

In this way we can color graph using 3 colors at most.



Input : N = 3 , M = 2 , E = 3 , Edges = [ (0, 1) , (1, 2) , (0, 2) ]

Output : false

Explanation : Consider the three colors to be red, green.

We can color the vertex 0 with red, vertex 1 with blue.

As the vertex 2 is adjacent to both vertex 1 and 0 , so we cannot color with red and green.

Hence as we could not color all vertex of graph we return false.

 */
