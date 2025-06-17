import java.util.Scanner;
// Question Name: Maximum Difference Between Increasing Elements
public class day65_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = maximumDifference(nums);
        System.out.println("Maximum difference: " + result);

        scanner.close();
    }
    public static int maximumDifference(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    ans = Math.max(ans, nums[j] - nums[i]);
                }
            }
        }
        return ans;
    }
}
