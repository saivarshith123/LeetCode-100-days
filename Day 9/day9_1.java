import java.util.Scanner;
// Question Name: Minimum Operations to Make Array Values Equal to K
class day9_1 {
    public static int minOperations(int[] nums, int k) {
        for (int n : nums) if (n < k) return -1;
        int ops = 0;
        while (true) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) max = Math.max(max, num);
            if (max == k) return ops;
            int next = Integer.MIN_VALUE;
            for (int num : nums) if (num < max) next = Math.max(next, num);
            int h = next == Integer.MIN_VALUE ? k : next;
            for (int i = 0; i < nums.length; i++) if (nums[i] > h) nums[i] = h;
            ops++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the target value k: ");
        int k = sc.nextInt();
        int result = minOperations(nums, k);
        System.out.println("Minimum operations: " + result);
        sc.close();
    }
}
