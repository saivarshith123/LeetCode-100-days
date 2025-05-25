import java.util.Scanner;
// Question Name: Product of the array except self
public class day2_1 {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pro = new int[len];
        pro[0] = 1;
        for (int i = 1; i < len; i++) {
            pro[i] = pro[i-1] * nums[i-1];
        }
        int rightProduct = 1;
        for (int i = len-1; i >= 0; i--) {
            pro[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return pro;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = productExceptSelf(arr); 
        System.out.print("Output: ");
        for (int j = 0; j < n; j++) {
            System.out.print(result[j]); 
            if (j < n - 1) System.out.print(", ");
        }
        System.out.println();
        sc.close();
    }
}