import java.util.Scanner;
// Question Name: Count the Number of Arrays with K Matching Adjacent Elements
public class day66_0 {
    static int mod = 1_000_000_007;
    static long[] revs = new long[100001];
    static int[] f = new int[100001];
    public static int countGoodArrays(int n, int m, int k) {
        if (f[0] == 0)
            f[0] = 1;
        long res = m * pow(m - 1, n - 1 - k) % mod * C(n - 1, n - 1 - k) % mod;
        return (int) res;
    }
    public static long pow(int a, int b) {
        long res = 1;
        long base = a;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            b /= 2;
        }
        return res;
    }
    public static long C(int a, int b) {
        return (long) getF(a) * rev(getF(a - b)) % mod * rev(getF(b)) % mod;
    }
    public static long getF(int a) {
        if (f[a] != 0) 
            return f[a];
        return f[a] = (int) (getF(a - 1) * a % mod);
    }
    public static long rev(long a) {
        if (a == 1)
            return a;
        return mod - mod / a * rev(mod % a) % mod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();
        System.out.print("Enter value of m: ");
        int m = sc.nextInt();
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();
        int result = countGoodArrays(n, m, k);
        System.out.println("Result: " + result);
        sc.close();
    }
}
