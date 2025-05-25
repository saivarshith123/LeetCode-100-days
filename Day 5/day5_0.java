import java.util.Scanner;
// Question name: Count Equal and Divisible Pairs in an Array
public class day5_0 {
    public static int countPairs(int[] nums, int k) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(countPairs(nums, k));
        scanner.close();
    }
}
