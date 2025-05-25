import java.util.*;
// Question Name: Three Consecutive Odds
public class day29_0 {
    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 1) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int a = sc.nextInt();
        int[] arr = new int[a];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        boolean result = threeConsecutiveOdds(arr);
        System.out.println("Contains three consecutive odd numbers: " + result);
        sc.close();
    }
}
