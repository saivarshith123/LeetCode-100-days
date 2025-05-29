import java.util.*;
// Question Name: Maximize the Number of Target Nodes After Connecting Trees II
public class day47_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of edges in Tree 1: ");
        int m1 = scanner.nextInt();
        int[][] edges1 = new int[m1][2];
        System.out.println("Enter edges for Tree 1 (each as two integers u v):");
        for (int i = 0; i < m1; i++) {
            edges1[i][0] = scanner.nextInt();
            edges1[i][1] = scanner.nextInt();
        }
        System.out.print("Enter number of edges in Tree 2: ");
        int m2 = scanner.nextInt();
        int[][] edges2 = new int[m2][2];
        System.out.println("Enter edges for Tree 2 (each as two integers u v):");
        for (int i = 0; i < m2; i++) {
            edges2[i][0] = scanner.nextInt();
            edges2[i][1] = scanner.nextInt();
        }
        day47_0 sol = new day47_0();
        int[] result = sol.maxTargetNodes(edges1, edges2);
        System.out.println("Result:");
        for (int val : result) {
            System.out.print(val + " ");
        }
        scanner.close();
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;
        ArrayList<Integer>[] adj1 = getAdjacency(edges1);
        ArrayList<Integer>[] adj2 = getAdjacency(edges2);
        int[] depth1 = new int[n1];
        int[] depth2 = new int[n2];
        fillDepths(0, -1, 0, adj1, depth1);
        fillDepths(0, -1, 0, adj2, depth2);
        int[] count1 = new int[2];
        int[] count2 = new int[2];
        for (int i = 0; i < n1; i++) count1[depth1[i] % 2]++;
        for (int i = 0; i < n2; i++) count2[depth2[i] % 2]++;
        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            int parity = depth1[i] % 2;
            ans[i] = count1[parity] + Math.max(count2[0], count2[1]);
        }
        return ans;
    }

    void fillDepths(int node, int parent, int depth, ArrayList<Integer>[] adj, int[] depths) {
        depths[node] = depth;
        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                fillDepths(neighbor, node, depth + 1, adj, depths);
            }
        }
    }

    ArrayList<Integer>[] getAdjacency(int[][] edges) {
        int n = edges.length + 1;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] d : edges) {
            adj[d[0]].add(d[1]);
            adj[d[1]].add(d[0]);
        }
        return adj;
    }
}
