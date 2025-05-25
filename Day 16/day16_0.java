import java.util.Scanner;
// Question Name: Count Subarrays With Score Less Than K
public class day16_0 {
    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements in the array: ");
        int n = scanner.nextInt();
        System.out.print("Enter the value of k: ");
        long k = scanner.nextLong();
        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        long result = countSubarrays(nums, k);
        System.out.println("Number of valid subarrays: " + result);
        scanner.close();
    }
}
