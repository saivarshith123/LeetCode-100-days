import java.util.*;
// Question Name: Count the Number of Fair Pairs
class day7_0 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1, left = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= lower - nums[i]) {
                    left = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            l = i + 1;
            r = n - 1;
            int right = i;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] <= upper - nums[i]) {
                    right = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (left <= right) count += right - left + 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter lower bound: ");
        int lower = scanner.nextInt();
        System.out.print("Enter upper bound: ");
        int upper = scanner.nextInt();
        day7_0 solution = new day7_0();
        long result = solution.countFairPairs(nums, lower, upper);
        System.out.println("Number of fair pairs: " + result);
		scanner.close();
    }
}
