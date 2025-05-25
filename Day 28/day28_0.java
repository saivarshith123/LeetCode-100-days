import java.util.*;
// Question Name: Minimum Equal Sum of Two Arrays After Replacing Zeros
public class day28_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of nums1:");
        int size1 = scanner.nextInt();
        int[] nums1 = new int[size1];
        System.out.println("Enter elements of nums1:");
        for (int i = 0; i < size1; i++) {
            nums1[i] = scanner.nextInt();
        }
        System.out.println("Enter the size of nums2:");
        int size2 = scanner.nextInt();
        int[] nums2 = new int[size2];
        System.out.println("Enter elements of nums2:");
        for (int i = 0; i < size2; i++) {
            nums2[i] = scanner.nextInt();
        }
        long result = minSum(nums1, nums2);
        System.out.println("Minimum possible equal sum: " + result);
        scanner.close();
    }
    public static long minSum(int[] nums1, int[] nums2) {
        long[] result1 = calculateSumAndZeroCount(nums1);
        long[] result2 = calculateSumAndZeroCount(nums2);
        long total1 = result1[0] + result1[1];
        long total2 = result2[0] + result2[1];
        if (total1 == total2) return total1;
        long[] smallerResult = total1 < total2 ? result1 : result2;
        long[] largerResult = (smallerResult == result1 ? result2 : result1);
        return smallerResult[1] == 0 ? -1 : largerResult[0] + largerResult[1];
    }
    private static long[] calculateSumAndZeroCount(int[] nums) {
        long[] sumAndZeroCount = {0, 0};
        for (int num : nums) {
            if (num == 0) sumAndZeroCount[1]++;
            sumAndZeroCount[0] += num;
        }
        return sumAndZeroCount;
    }
}
