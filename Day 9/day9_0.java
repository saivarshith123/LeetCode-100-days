import java.util.Scanner;
// Question Name: Count the Hidden Sequences
class day9_0 {
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        long run = 0;
        long min = 0;
        long max = 0;
        for(int i = 0; i < differences.length; i++){
            run = run + differences[i];
            min = Math.min(min, run);
            max = Math.max(max, run);
        }
        int total = Math.max(0, (int) (upper - lower - (max - min) + 1));
        return total;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the lower range value: ");
        int low = sc.nextInt();
        System.out.print("Enter the high range value: ");
        int high = sc.nextInt();
        int result = numberOfArrays(arr, low, high);
        System.out.println("Number of possible hidden sequences: "+result);
        sc.close();
    }
}
