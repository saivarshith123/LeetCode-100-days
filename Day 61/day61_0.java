import java.util.Scanner;
// Question Name: Maximum Difference Between Adjacent Elements in a Circular Array
public class day61_0 {
    public static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxa = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; i++) {
            maxa = Math.max(maxa, Math.abs(nums[i] - nums[i + 1]));
        }
        return maxa;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int mm = maxAdjacentDistance(arr);
        System.out.println("Maximum absolute difference between adjacent elements: "+mm);
        sc.close();
    }
}