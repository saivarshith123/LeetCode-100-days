import java.util.*;
// QUestion Name: Spiral Matrix II
public class day68_1 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int num = 1;
        while (num <= n * n) {
            // Traverse right
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++;
            }
            rowStart++;
            // Traverse down
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;
            // Traverse left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = num++;
                }
            }
            rowEnd--;
            // Traverse up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = num++;
                }
            }
            colStart++;
        }
        return matrix;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        int n = sc.nextInt();
        int[][] result = generateMatrix(n);
        System.out.println("The final resultent matrix: ");
        if (result.length == 0) {
            System.out.println("It's not possible");
        } else {
            System.out.println("The divided array is:");
            for (int[] group : result) {
                System.out.println(Arrays.toString(group));
            }
        }
        sc.close();
    }
}
