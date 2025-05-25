import java.util.*;
// Question Name: Find Numbers with Even Number of Digits
public class day18_0 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int digitCount = 0;
            int n = nums[i];
            while (n > 0) {
                digitCount++;
                n = n / 10;
            }
            if (digitCount % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        day18_0 obj = new day18_0();
        int result = obj.findNumbers(nums);
        System.out.println("Number of valid numbers with even digits: " + result);
        scanner.close();
    }
}
