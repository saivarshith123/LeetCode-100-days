import java.util.*;
// Question Name: Partition Array Such That Maximum Difference Is K
public class day68_0 {
    public static int PartitionArray(int[] arr, int k){
        Arrays.sort(arr);
        int min = arr[0];
        int count = 1;
        int len = arr.length;
        for(int i=0;i<len;i++){
            if(arr[i] - min > k){
                count++;
                min = arr[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the max difference should have: ");
        int k = sc.nextInt();
        int result = PartitionArray(arr, k);
        System.out.println("Minimum number of subsequences: "+result);
        sc.close();
    }
}
