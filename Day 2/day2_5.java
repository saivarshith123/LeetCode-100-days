import java.util.Scanner;
// Question Name: Print nth Fibonacci number
public class day2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scanner.nextInt();
        scanner.close();
        int fibonacci;
        if (n <= 1) {
            fibonacci = n;
        } else {
            fibonacci = Help(n);
        }
        System.out.println(fibonacci);
    }
    public static int Help(int n) {
        if (n <= 1) {
            return n;
        }
        return Help(n - 1) + Help(n - 2);
    }
}