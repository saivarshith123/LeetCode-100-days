import java.util.*;
// Question Name: Snakes and Ladders
public class day49_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (n): ");
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        System.out.println("Enter the board row by row (use -1 for empty cells):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int result = snakesAndLadders(board);
        System.out.println("Minimum moves to reach the end: " + result);
        scanner.close();
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int moves = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(1);
        visited[n - 1][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int currBoardVal = q.poll();
                if (currBoardVal == n * n)
                    return moves;
                for (int diceVal = 1; diceVal <= 6; diceVal++) {
                    if (currBoardVal + diceVal > n * n)
                        break;
                    int[] pos = findCoordinates(currBoardVal + diceVal, n);
                    int row = pos[0];
                    int col = pos[1];
                    if (!visited[row][col]) {
                        visited[row][col] = true;
                        if (board[row][col] == -1) {
                            q.add(currBoardVal + diceVal);
                        } else {
                            q.add(board[row][col]);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    public static int[] findCoordinates(int curr, int n) {
        int r = n - (curr - 1) / n - 1;
        int c = (curr - 1) % n;
        if (r % 2 == n % 2) {
            return new int[] { r, n - 1 - c };
        } else {
            return new int[] { r, c };
        }
    }
}
