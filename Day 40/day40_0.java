import java.util.*;
// Question Name: Zero Array Transformation III
public class day40_0 {
    public static int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (q1, q2) -> q1[0] - q2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((q1, q2) -> q2[1] - q1[1]);

        int q = 0, d = 0, res = 0;
        int[] delta = new int[nums.length + 2];

        for (int i = 0; i < nums.length; i++) {
            d += delta[i];
            if ((nums[i] - d) > 0) {
                while (q < queries.length && queries[q][0] <= i) {
                    pq.offer(queries[q++]);
                }
            }
            while ((nums[i] - d) > 0 && !pq.isEmpty() && pq.peek()[1] >= i) {
                int[] query = pq.poll();
                res++;
                delta[query[0]]++;
                delta[query[1] + 1]--;
                d++;
            }
            if (nums[i] - d > 0) {
                return -1;
            }
        }

        return queries.length - res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of nums array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements of nums array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of queries: ");
        int m = sc.nextInt();
        int[][] queries = new int[m][2];
        System.out.println("Enter queries as [l r] pairs:");
        for (int i = 0; i < m; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        int result = maxRemoval(nums, queries);
        System.out.println("Maximum number of queries that can be removed: " + result);
        sc.close();
    }
}