import java.util.*;
// Question Name: Build Array from Permutation
public class day24_0 {
    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements (0 to " + (n - 1) + ", no duplicates):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] result = buildArray(nums);
        System.out.println("Output array: " + Arrays.toString(result));
        scanner.close();
    }
}
