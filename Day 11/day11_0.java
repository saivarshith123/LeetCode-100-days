import java.util.Scanner;
// Question Name: Count Largest Group
public class day11_0 {
    public static int countLargestGroup(int n) {
        int[] count = new int[37];
        int max = 0, res = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, ++count[digitSum(i)]);
        for (int c : count)
            if (c == max) res++;
        return res;
    }
    private static int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        int result = countLargestGroup(n);
        System.out.println("Number of groups that have the largest size: "+result);
        sc.close();
    }
}
