import java.util.Scanner;
// Question Name: Distribute Candies Among Children II
public class day50_0 {
    public long distributeCandies(int n, int limit) {
        java.util.function.LongUnaryOperator C2 = x -> (x >= 2) ? (x * (x - 1) / 2) : 0L;
        long N = n, L = limit;
        long total = (N + 2) * (N + 1) / 2;
        long x1 = N - L + 1;
        long t1 = C2.applyAsLong(x1);
        long x2 = N - 2 * L;
        long t2 = C2.applyAsLong(x2);
        long x3 = N - 3 * L - 1;
        long t3 = C2.applyAsLong(x3);
        return total - 3 * t1 + 3 * t2 - t3;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n (total candies): ");
        int n = scanner.nextInt();
        System.out.print("Enter limit (max candies per person): ");
        int limit = scanner.nextInt();
        day50_0 solution = new day50_0();
        long result = solution.distributeCandies(n, limit);
        System.out.println("Number of ways to distribute candies: " + result);
        scanner.close();
    }
}