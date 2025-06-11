import java.util.*;
// Question Name: Maximum Difference Between Even and Odd Frequency II
public class day60_0 {
    private static int[][] pre;
    private static int parity(int num) {
        return num & 1;
    }
    private static int max_subarray_sum(int a, int b, String s, int k) {
        int n = s.length();
        int l = 0, r = k - 1;
        int r_freq_a = 0, r_freq_b = 0;
        int l_freq_a = 0, l_freq_b = 0;
        int sum = Integer.MIN_VALUE;
        final int INF = 100000000;
        int[][] mat = {{INF, INF}, {INF, INF}};
        while (r < n) {
            r_freq_a = pre[a][r + 1];
            r_freq_b = pre[b][r + 1];
            while (r - l + 1 >= k && (r_freq_b - l_freq_b) >= 2) {
                mat[parity(l_freq_a)][parity(l_freq_b)] = Math.min(mat[parity(l_freq_a)][parity(l_freq_b)], l_freq_a - l_freq_b);
                l_freq_a = pre[a][l + 1];
                l_freq_b = pre[b][l + 1];
                l++;
            }
            int calc = (r_freq_a - r_freq_b) - mat[parity(r_freq_a) ^ 1][parity(r_freq_b)];
            sum = Math.max(calc, sum);
            r++;
        }
        return sum;
    }
    public static int maxDifference(String s, int k) {
        int n = s.length();
        pre = new int[5][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 4; j++) {
                pre[j][i + 1] = pre[j][i];
            }
            int conv = s.charAt(i) - '0';
            pre[conv][i + 1]++;
        }
        int diff = Integer.MIN_VALUE;
        for (int i = 0; i <= 4; i++) {
            if (pre[i][n] == 0) continue;
            for (int j = 0; j <= 4; j++) {
                if (i == j || pre[j][n] == 0) continue;
                int calc = max_subarray_sum(i, j, s, k);
                diff = Math.max(diff, calc);
            }
        }
        return diff;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the numeric string (digits 0–4): ");
        String s = scanner.nextLine();
        System.out.print("Enter the minimum subarray length k: ");
        int k = scanner.nextInt();
        scanner.close();
        int result = maxDifference(s, k);
        System.out.println("Max difference: " + result);
    }
}
