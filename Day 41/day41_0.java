import java.util.*;
// Question Name: Find the Maximum Sum of Node Values
public class day41_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in nums: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter the elements of nums: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();
        int[][] edges = new int[m][2];
        System.out.println("Enter the edges (each as two space-separated integers): ");
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        long result = maximumValueSum(nums, k, edges);
        System.out.println("Maximum Value Sum: " + result);
        scanner.close();
    }
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long base = 0, sumPos = 0;
        int cntPos = 0;
        long minPos = Long.MAX_VALUE;
        long bestNonpos = Long.MIN_VALUE;
        boolean sawNonpos = false;
        for (int x : nums) {
            base += x;
            long d = (long)(x ^ k) - x;
            if (d > 0) {
                cntPos++;
                sumPos += d;
                if (d < minPos) minPos = d;
            } else {
                if (!sawNonpos || d > bestNonpos) {
                    bestNonpos = d;
                    sawNonpos = true;
                }
            }
        }
        if ((cntPos & 1) == 0) {
            return base + sumPos;
        }
        long loss = minPos;
        if (sawNonpos) {
            loss = Math.min(loss, -bestNonpos);
        }
        return base + sumPos - loss;
    }
}
