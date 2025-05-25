import java.util.*;
// Question Name: Count Complete Subarrays in an Array
public class day12_0 {
    public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length, res = 0, total = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++)
                if (nums[i] == nums[j]) found = true;
            if (!found) total++;
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                boolean dup = false;
                for (int k = i; k < j; k++)
                    if (nums[j] == nums[k]) dup = true;
                if (!dup) count++;
                if (count == total) res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length od the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int result = countCompleteSubarrays(arr);
        System.out.println(result);
        sc.close();
    }
}
