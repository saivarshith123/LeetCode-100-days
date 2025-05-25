import java.util.Scanner;
// Question name : Count Good Numbers
public class day1_0{
    static final int M = 1_000_000_007;
    static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long half = pow(a, b / 2);
        long result = (half * half) % M;
        if (b % 2 == 1) {
            result = (result * a) % M;
        }
        return result;
    }
    static int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        long result = (pow(5, even) * pow(4, odd)) % M;
        return (int) result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long n = sc.nextLong();
        int result = countGoodNumbers(n);
        System.out.println("Count of good numbers: " + result);
        sc.close();
    }
}