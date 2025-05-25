import java.util.Scanner;
// Question Name : Number of Equivalent Domino Pairs
public class day22_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of dominoes: ");
        int n = sc.nextInt();
        int[][] dominoes = new int[n][2];
        System.out.println("Enter each domino (2 integers per line):");
        for (int i = 0; i < n; i++) {
            dominoes[i][0] = sc.nextInt();
            dominoes[i][1] = sc.nextInt();
        }
        int result = numEquivDominoPairs(dominoes);
        System.out.println("Number of equivalent domino pairs: " + result);
        sc.close();
    }
    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100]; 
        int result = 0;

        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            int key = Math.min(a, b) * 10 + Math.max(a, b);
            result += count[key];
            count[key]++;
        }
        return result;
    }
}
