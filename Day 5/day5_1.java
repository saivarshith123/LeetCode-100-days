import java.util.Scanner;
// Question Name: Plus One
class day5_1 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of digits: ");
        int n = scanner.nextInt();
        int[] digits = new int[n];
        System.out.println("Enter the digits one by one:");
        for (int i = 0; i < n; i++) {
            digits[i] = scanner.nextInt();
        }
        day5_1 sol = new day5_1();
        int[] result = sol.plusOne(digits);
        System.out.print("Result after plus one: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
