import java.util.*;
// Question Name: Largest Color Value in a Directed Graph
public class day44_0 {
    public static int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] col = new int[n];
        for (int i = 0; i < n; i++) col[i] = colors.charAt(i) - 'a';
        int[] outdeg = new int[n];
        for (int[] e : edges) outdeg[e[0]]++;
        int[][] adj = new int[n][];
        for (int i = 0; i < n; i++) adj[i] = new int[outdeg[i]];
        int[] ptr = new int[n];
        int[] indeg = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u][ptr[u]++] = v;
            indeg[v]++;
        }
        int[][] dp = new int[n][26];
        int[] queue = new int[n];
        int qh = 0, qt = 0;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                dp[i][col[i]] = 1;
                queue[qt++] = i;
            }
        }
        int seen = 0, ans = 0;
        while (qh < qt) {
            int u = queue[qh++];
            seen++;
            for (int c = 0; c < 26; c++) {
                if (dp[u][c] > ans) ans = dp[u][c];
            }
            for (int v : adj[u]) {
                int cv = col[v];
                int[] dpu = dp[u], dpv = dp[v];
                for (int c = 0; c < 26; c++) {
                    int val = dpu[c] + (c == cv ? 1 : 0);
                    if (val > dpv[c]) dpv[c] = val;
                }
                if (--indeg[v] == 0) {
                    queue[qt++] = v;
                }
            }
            dp[u] = null;
        }
        return seen == n ? ans : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the colors string: ");
        String colors = scanner.nextLine();
        System.out.print("Enter the number of edges: ");
        int edgeCount = scanner.nextInt();
        int[][] edges = new int[edgeCount][2];
        System.out.println("Enter each edge as two space-separated integers (from -> to):");
        for (int i = 0; i < edgeCount; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        int result = largestPathValue(colors, edges);
        System.out.println("Largest path value: " + result);
        scanner.close();
    }
}
