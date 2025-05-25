import java.util.Scanner;
// Question Name : Count Number of Balanced Permutations
public class day27_0 {
    private static final int[] cnt = new int[10];
    private static final int mod = (int) 1e9 + 7;
    private static Integer[][][][] f;
    private static long[][] c;

    public static int countBalancedPermutations(String num) {
        for (int i = 0; i < 10; i++) cnt[i] = 0;
        int s = 0;
        for (char ch : num.toCharArray()) {
            cnt[ch - '0']++;
            s += ch - '0';
        }
        if (s % 2 == 1) return 0;
        int n = num.length();
        int m = n / 2 + 1;
        f = new Integer[10][s / 2 + 1][m][m + 1];
        c = new long[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
            }
        }
        return dfs(0, s / 2, n / 2, (n + 1) / 2);
    }

    private static int dfs(int i, int j, int a, int b) {
        if (i > 9) return ((j | a | b) == 0) ? 1 : 0;
        if (a == 0 && j != 0) return 0;
        if (f[i][j][a][b] != null) return f[i][j][a][b];
        int ans = 0;
        for (int l = 0; l <= Math.min(cnt[i], a); ++l) {
            int r = cnt[i] - l;
            if (r >= 0 && r <= b && l * i <= j) {
                int t = (int) (c[a][l] * c[b][r] % mod * dfs(i + 1, j - l * i, a - l, b - r) % mod);
                ans = (ans + t) % mod;
            }
        }
        return f[i][j][a][b] = ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number string: ");
        String num = scanner.nextLine().trim();
        int result = countBalancedPermutations(num);
        System.out.println("Balanced permutations count: " + result);
        scanner.close();
    }
}
