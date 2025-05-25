import java.util.*;
// Question Name: Count of Interesting Subarrays
public class day13_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        int modulo = sc.nextInt();
        int k = sc.nextInt();
        long result = countInterestingSubarrays(nums, modulo, k);
        System.out.println(result);
        sc.close();
    }
    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> prefixModCount = new HashMap<>();
        prefixModCount.put(0, 1L);
        long result = 0;
        int prefix = 0;
        for (int num : nums) {
            if (num % modulo == k) {
                prefix++;
            }
            int currentMod = prefix % modulo;
            int target = (currentMod - k + modulo) % modulo;
            result += prefixModCount.getOrDefault(target, 0L);
            prefixModCount.put(currentMod, prefixModCount.getOrDefault(currentMod, 0L) + 1);
        }
        return result;
    }
}
