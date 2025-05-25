import java.util.Scanner;
// Question Name: Minimum Domino Rotations For Equal Row
public class day21_0 {
    public static int minDominoRotations(int[] top, int[] bottom) {
        int n = top.length;
        int a = top[0], b = bottom[0];
        for (int i = 1; i < n; i++) {
            if (a != top[i] && a != bottom[i]) a = -1;
            if (b != top[i] && b != bottom[i]) b = -1;
            if (a == -1 && b == -1) return -1;
        }
        a = a != -1 ? a : b;
        int tswap = 0, bswap = 0;
        for (int i = 0; i < n; i++) {
            if (a != top[i]) tswap++;
            if (a != bottom[i]) bswap++;
        }
        return Math.min(tswap, bswap);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of dominoes: ");
        int n = scanner.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        System.out.print("Enter top row values (space separated): ");
        for (int i = 0; i < n; i++) top[i] = scanner.nextInt();
        System.out.print("Enter bottom row values (space separated): ");
        for (int i = 0; i < n; i++) bottom[i] = scanner.nextInt();
        int result = minDominoRotations(top, bottom);
        System.out.println("Minimum number of rotations needed: " + result);
        scanner.close();
    }
}
