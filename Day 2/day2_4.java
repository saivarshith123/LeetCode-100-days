import java.util.*;
// Question Name: Tower Of Hanoi
public class day2_4 {
    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 0) return;
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println(from_rod + " " + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        System.out.print("Enter the from char: ");
        char from_rod = scanner.next().charAt(0);
        System.out.print("Enter the mid char: ");
        char mid_rod = scanner.next().charAt(0);
        System.out.print("Enter the to char: ");
        char to_rod = scanner.next().charAt(0);
        towerOfHanoi(N, from_rod, to_rod, mid_rod);
        scanner.close();
    }
}