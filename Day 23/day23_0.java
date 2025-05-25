import java.util.Scanner;
// Question Name: Domino and Tromino Tiling
public class day23_0 {
    public static int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }

        return (int) dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n (1 <= n <= 1000): ");
        int n = scanner.nextInt();
        if (n < 1 || n > 1000) {
            System.out.println("Invalid input. Please enter a number between 1 and 1000.");
        } else {
            int result = numTilings(n);
            System.out.println("Number of ways to tile a 2 x " + n + " board: " + result);
        }
        scanner.close();
    }
}
