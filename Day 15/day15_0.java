import java.util.Scanner;
// Question Name: Count Subarrays of length Three With a Condition
public class day15_0 {
    public static int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            double halfSecond = second / 2.0;
            if (first + third == halfSecond) {
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
        int result = countSubarrays(nums);
        System.out.println("Number of valid subarrays: " + result);
        scanner.close();
    }
}
