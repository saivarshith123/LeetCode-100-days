import java.util.*;
// Question Name: Zero Array Transformation I
public class day38_0{
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            diff[q[0]]++;
            if (q[1] + 1 < diff.length) {
                diff[q[1] + 1]--;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (nums[i] <= sum) {
                nums[i] = 0;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of nums array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements of nums array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();
        int[][] queries = new int[q][2];
        System.out.println("Enter the queries as pairs [l r]:");
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        boolean result = isZeroArray(nums, queries);
        System.out.println("Output: " + result);
        sc.close();
    }
}