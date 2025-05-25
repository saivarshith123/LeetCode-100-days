import java.util.Scanner;
// Question name: Pots of gold coin
public class day1_2 {
    public static int maxCoins(int[] arr, int i, int j) {
        if (i > j) return 0;
        int pickI = arr[i] + Math.min(
            maxCoins(arr, i + 2, j),
            maxCoins(arr, i + 1, j - 1)
        );
        int pickJ = arr[j] + Math.min(
            maxCoins(arr, i + 1, j - 1),
            maxCoins(arr, i, j - 2)
        );
        return Math.max(pickI, pickJ);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        } 
        System.out.println(maxCoins(coins, 0, n - 1));
        sc.close();
    }
}
