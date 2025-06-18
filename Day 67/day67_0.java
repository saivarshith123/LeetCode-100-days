import java.util.Arrays;
import java.util.Scanner;
public class day67_0{
    public int[][] divideArray(int[] nums, int k) {
        int[][] ans = new int[nums.length /3][3];
        Arrays.sort(nums);
        for(int i=2;i<nums.length;i+=3){
            if(nums[i] - nums[i-2] > k){
                return new int[0][];
            }
            ans[i / 3] = new int[] {nums[i - 2], nums[i - 1], nums[i]};
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of te array: ");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the positive integer: ");
        int k = sc.nextInt();
        day67_0 ss = new day67_0();
        int[][] result = ss.divideArray(nums, k);
        if (result.length == 0) {
            System.out.println("It's not possible to divide the array as required.");
        } else {
            System.out.println("The divided array is:");
            for (int[] group : result) {
                System.out.println(Arrays.toString(group));
            }
        }
        sc.close();
    }
}
