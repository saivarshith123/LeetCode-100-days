import java.util.Scanner;
// Question Name: Celebrity Problem
public class day2_2 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.print("Enter the size of the matrix: ");
        int n = sca.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sca.nextInt();
            }
        }
        sca.close();
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 0) {
                    count++;
                } else {
                    count = 0; 
                    break;
                }
            }
            if(count == n) {
                boolean knownByAll = true;
                for(int k = 0; k < n; k++) {
                    if(k != i && a[k][i] != 1) {
                        knownByAll = false;
                        break;
                    }
                }
                if(knownByAll) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println("No Celebrity");
    }
}
