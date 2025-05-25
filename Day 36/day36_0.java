import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Question Name: Painting a Grid With Three Different Colors
public class day36_0{
    public static int ColorTheGrid(int m, int n){
        final int mod = 1_000_000_007;
        int total = 1;
        for (int i = 0; i < m; i++) total *= 3;
        int[][] dp = new int[n+1][total];
        int[][] rowValid = new int[total][total];
        List<Integer> good = new ArrayList<>();
        List<Integer>[] pattern = new ArrayList[total];
        for (int i = 0; i < total; i++) pattern[i] = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            int val = i, valid = 1;
            for (int j = 0; j < m; j++) {
                pattern[i].add(val % 3);
                val /= 3;
            }
            for (int j = 1; j < m; j++) if (pattern[i].get(j).equals(pattern[i].get(j-1))) valid = 0;
            if (valid == 1) good.add(i);
        }
        for (int i : good) dp[1][i] = 1;
        for (int i : good) {
            for (int j : good) {
                rowValid[i][j] = 1;
                for (int k = 0; k < m; k++) if (pattern[i].get(k).equals(pattern[j].get(k))) rowValid[i][j] = 0;
            }
        }
        for (int col = 2; col <= n; col++) {
            for (int i : good) {
                long sum = 0;
                for (int j : good) if (rowValid[i][j] == 1) sum += dp[col-1][j];
                dp[col][i] = (int)(sum % mod);
            }
        }
        long ans = 0;
        for (int i = 0; i < total; i++) ans += dp[n][i];
        return (int)(ans % mod);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;
        System.out.print("Enter the value of first number: ");
        n = sc.nextInt();
        System.out.print("Enter the value of second number: ");
        m = sc.nextInt();
        System.out.println("Number of ways to color the grid with no two adjacent cells having the same color: ");
        int result = ColorTheGrid(m,n);
        System.out.println(result);
        sc.close();
    }
}