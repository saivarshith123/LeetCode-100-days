import java.util.Arrays;
import java.util.Scanner;
// Question Name: Count the Number of Ideal Arrays
public class day10_0 {
    private static int[][] memoization;
    private static int[][] combinationMatrix;
    private static int numElements;
    private static int maxValue;
    private static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int inputMaxValue = sc.nextInt();
            int result = idealArrays(n, inputMaxValue);
            System.out.println(result);
        }
        sc.close();
    }
    public static int idealArrays(int n, int inputMaxValue) {
        numElements = n;
        maxValue = inputMaxValue;
        memoization = new int[maxValue + 1][n + 1];
        for (int[] row : memoization) Arrays.fill(row, -1);
        combinationMatrix = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j <= i; ++j)
                combinationMatrix[i][j] = (j == 0 ? 1 : (combinationMatrix[i - 1][j] + combinationMatrix[i - 1][j - 1]) % MOD);
        int answer = 0;
        for (int i = 1; i <= maxValue; ++i)
            answer = (answer + dfs(i, 1)) % MOD;
        return answer;
    }
    private static int dfs(int startValue, int length) {
        if (memoization[startValue][length] != -1) return memoization[startValue][length];
        int count = combinationMatrix[numElements - 1][length - 1];
        if (length < numElements)
            for (int k = 2; startValue * k <= maxValue; ++k)
                count = (count + dfs(startValue * k, length + 1)) % MOD;
        memoization[startValue][length] = count;
        return count;
    }
}
