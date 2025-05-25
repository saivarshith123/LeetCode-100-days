import java.util.Scanner;
// Question Name: Stock Span
public class day2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] res = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            res[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(arr[j] <= arr[i]){
                    res[j]++;
                } else {
                    break;
                }
            }
        }
        for(int a=0;a<n;a++){
            System.out.print(res[a] + " ");
        }
        sc.close();
    }
}
