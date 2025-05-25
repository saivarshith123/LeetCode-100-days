import java.util.*;
// Question Name: Find Minimum Time to Reach Last Room I
public class day25_0 {
    public static int minTimeToReach(int[][] moveTime) {
        final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int m = moveTime.length;
        final int n = moveTime[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, 0, 0});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int d = curr[0], i = curr[1], j = curr[2];
            if (i == m - 1 && j == n - 1) return d;
            if (d > dist[i][j]) continue;
            for (int[] dir : DIRS) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                int newDist = Math.max(moveTime[x][y], d) + 1;
                if (newDist < dist[x][y]) {
                    dist[x][y] = newDist;
                    minHeap.offer(new int[]{newDist, x, y});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = scanner.nextInt();
        int[][] moveTime = new int[m][n];
        System.out.println("Enter the moveTime matrix values row by row:");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                moveTime[i][j] = scanner.nextInt();
        int result = minTimeToReach(moveTime);
        System.out.println("Minimum time to reach destination: " + result);
        scanner.close();
    }
}