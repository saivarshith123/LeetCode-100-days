import java.util.Scanner;
// Question Name: Divisible and Non-divisible Sums Difference
public class day45_0 {
    public static int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for(int i=1; i<=n;i++){
            if(i % m != 0){
                num1 = num1 + i;
            } else {
                num2 = num2 + i;
            }
        }
        int result = num1 - num2;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the n value: ");
        int n = sc.nextInt();
        System.out.print("Enter the m value: ");
        int m = sc.nextInt();
        int rr = differenceOfSums(n, m);
        System.out.println("Divisible and Non-divisible Sums Difference: "+rr);
        sc.close();
    }
}