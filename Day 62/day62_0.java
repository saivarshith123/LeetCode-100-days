import java.util.*;
// Question Name: Minimize the Maximum Difference of Pairs
public class day62_0 {
    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int len = nums.length;
        int lo = -1;
        int hi = (int)1e9 + 7;
        while(lo < hi-1){
            int mid = lo + (hi-lo) / 2;
            int count = 0;
            for(int i=1;i<len;i++){
                if (nums[i] - nums[i - 1] <= mid) {
                    count++;
                    i++; 
                }
            }
            if (count >= p) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the integer: ");
        int p = sc.nextInt();
        int result = minimizeMax(arr, p);
        System.out.println("Minimum maximum difference among all: "+result);
        sc.close();
    }
}