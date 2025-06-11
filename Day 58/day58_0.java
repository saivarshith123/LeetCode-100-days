import java.util.*;
// Question Name: K-th Smallest in Lexicographical Order
public class day58_0 {
    public static int findKthNumber(int n, int k) {
        long curr = 1;
        k -= 1;
        while (k > 0) {
            long count = getCount(curr, n);
            if (count <= k) {
                curr++;
                k -= count;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return (int) curr;
    }
    private static long getCount(long prefix, long n) {
        long count = 0;
        long current = prefix;
        long next = prefix + 1;
        while (current <= n) {
            count += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter k: ");
        int k = scanner.nextInt();
        scanner.close();
        int result = findKthNumber(n, k);
        System.out.println("The " + k + "th smallest number in lexicographical order is: " + result);
    }
}