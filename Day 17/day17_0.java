import java.util.*;
// Question Name: Count Subarrays Where Max Element Appears at Least K Times
public class day17_0 {
    public static long countSubarrays(int[] nums, int k) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        long countOfSubarrays = 0;
        int maxCount = 0;
        int rightPointer = 0;
        for (int leftPointer = 0; leftPointer < n; leftPointer++) {
            while (rightPointer < n && maxCount < k) {
                if (nums[rightPointer] == maxNum) {
                    maxCount++;
                }
                rightPointer++;
            }
            if (maxCount < k) {
                break;
            }
            countOfSubarrays += n - rightPointer + 1;
            if (nums[leftPointer] == maxNum) {
                maxCount--;
            }
        }
        return countOfSubarrays;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements in the array: ");
        int n = scanner.nextInt();
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
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
