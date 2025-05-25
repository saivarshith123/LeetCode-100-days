import java.util.*;
// Question Name: Count the Number of Good Subarrays
public class day4_0 {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long totalPairs = 0;
        long result = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            int num = nums[right];
            totalPairs -= (long) freq.getOrDefault(num, 0) * (freq.getOrDefault(num, 0) - 1) / 2;
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            totalPairs += (long) freq.get(num) * (freq.get(num) - 1) / 2;
            while (left <= right && totalPairs >= k) {
                result += n - right;
                int numLeft = nums[left];
                totalPairs -= (long) freq.get(numLeft) * (freq.get(numLeft) - 1) / 2;
                freq.put(numLeft, freq.get(numLeft) - 1);
                totalPairs += (long) freq.get(numLeft) * (freq.get(numLeft) - 1) / 2;
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        day4_0 solution = new day4_0();  
        long result = solution.countGood(nums, k); 
        System.out.println("The number of good subarrays is: " + result);
        scanner.close();
    }
}
