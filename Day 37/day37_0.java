import java.util.*;
// Question Name: Types of Triangles
public class day37_0 {
    public static String triangle(int[] nums){
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]){
            return "none";
        }
        if (nums[0] == nums[1] && nums[1] == nums[2]){
        return "equilateral";
        }
        if (nums[0] == nums[1] || nums[1] == nums[2]){
        return "isosceles";
        }
        return "scalene";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        System.out.print("Enter the length of the first side: ");
        arr[0] = sc.nextInt();
        System.out.print("Enter the length of the secound side: ");
        arr[1] = sc.nextInt(); 
        System.out.print("Enter the length of the third side: ");
        arr[2] = sc.nextInt();
        String result = triangle(arr);
        System.out.println(result);
        sc.close();
    }
}