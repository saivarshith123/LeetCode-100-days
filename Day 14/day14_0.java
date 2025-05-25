import java.util.*;
// Question Name: Count Subarrays With Fixed Bounds
public class day14_0 {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;
        int lastInvalid = -1;
        int lastMin = -1;
        int lastMax = -1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num < minK || num > maxK) lastInvalid = i;
            if (num == minK) lastMin = i;
            if (num == maxK) lastMax = i;
            int validStart = Math.min(lastMin, lastMax);
            if (validStart > lastInvalid) count += validStart - lastInvalid;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        System.out.print("Enter minK: ");
        int minK = sc.nextInt();
        System.out.print("Enter maxK: ");
        int maxK = sc.nextInt();
        sc.close();
        long result = countSubarrays(nums, minK, maxK);
        System.out.println("Number of fixed-bound subarrays: " + result);
    }
}
