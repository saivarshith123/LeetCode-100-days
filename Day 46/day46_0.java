import java.util.*;
// Question Name: Maximize the Number of Target Nodes After Connecting Trees I
public class day46_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of edges in Graph 1: ");
        int e1 = sc.nextInt();
        int[][] edges1 = new int[e1][2];
        for (int i = 0; i < e1; i++) {
            edges1[i][0] = sc.nextInt();
            edges1[i][1] = sc.nextInt();
        }
        System.out.print("Enter number of edges in Graph 2: ");
        int e2 = sc.nextInt();
        int[][] edges2 = new int[e2][2];
        for (int i = 0; i < e2; i++) {
            edges2[i][0] = sc.nextInt();
            edges2[i][1] = sc.nextInt();
        }
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();
        int[] result = maxTargetNodes(edges1, edges2, k);
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
        sc.close();
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] ans = new int[n];
        if (k == 0) {
            Arrays.fill(ans, 1);
            return ans;
        }
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < n; i++) adj1.add(new ArrayList<>());
        for (int[] edge : edges1) {
            int u = edge[0], v = edge[1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < m; i++) adj2.add(new ArrayList<>());
        for (int[] edge : edges2) {
            int u = edge[0], v = edge[1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }
        int[] aux1 = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            aux1[i] = dfs(i, k, visited, adj1);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            boolean[] visited = new boolean[m];
            visited[i] = true;
            int t = dfs(i, k - 1, visited, adj2);
            max = Math.max(max, t);
        }
        for (int i = 0; i < n; i++) ans[i] = aux1[i] + max;
        return ans;
    }

    public static int dfs(int node, int k, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        if (k < 0) return 0;
        if (k == 0) return 1;
        int sum = 0;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                sum += dfs(neighbor, k - 1, visited, adj);
                visited[neighbor] = false;
            }
        }
        return sum + 1;
    }
}