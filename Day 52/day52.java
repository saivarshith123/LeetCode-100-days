import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class day52 {
    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes){
        int n = status.length;
        boolean[] hasBox = new boolean[n];
        boolean[] opened = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int totalCandies = 0;
        int boxesAvailable = 0;
        for (int boxIndex : initialBoxes) {
            hasBox[boxIndex] = true;
            if (status[boxIndex] == 1) {
                q.offer(boxIndex);
            } else {
                boxesAvailable++;
            }
        }
        while (!q.isEmpty()) {
            int boxIndex = q.poll();
            if (opened[boxIndex]) continue;
            opened[boxIndex] = true;
            totalCandies += candies[boxIndex];
            for (int key : keys[boxIndex]) {
                if (status[key] == 0) {
                    status[key] = 1;
                    if (hasBox[key]) {
                        q.offer(key);
                        boxesAvailable--;
                    }
                }
            }
            for (int containedBox : containedBoxes[boxIndex]) {
                if (!hasBox[containedBox]) {
                    hasBox[containedBox] = true;
                    if (status[containedBox] == 1) {
                        q.offer(containedBox);
                    } else {
                        boxesAvailable++;
                    }
                }
            }
            if (q.isEmpty() && boxesAvailable > 0) {
                boolean canOpen = false;
                for (int i = 0; i < n; i++) {
                    if (hasBox[i] && !opened[i] && status[i] == 1) {
                        q.offer(i);
                        canOpen = true;
                        boxesAvailable--;
                    }
                }
                if (!canOpen) return totalCandies;
            }
        }
        return totalCandies;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of boxes: ");
        int n = sc.nextInt();
        int[] status = new int[n];
        int[] candies = new int[n];
        int[][] keys = new int[n][];
        int[][] containedBoxes = new int[n][];
        System.out.println("Enter status (0 or 1) for each box:");
        for (int i = 0; i < n; i++) {
            status[i] = sc.nextInt();
        }
        System.out.println("Enter number of candies in each box:");
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
        }
        System.out.println("Enter keys in each box (enter number of keys followed by the keys):");
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            keys[i] = new int[len];
            for (int j = 0; j < len; j++) {
                keys[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter contained boxes in each box (enter number of boxes followed by the contained box indices):");
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            containedBoxes[i] = new int[len];
            for (int j = 0; j < len; j++) {
                containedBoxes[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter number of initial boxes: ");
        int m = sc.nextInt();
        int[] initialBoxes = new int[m];
        System.out.println("Enter initial box indices:");
        for (int i = 0; i < m; i++) {
            initialBoxes[i] = sc.nextInt();
        }
        int result = maxCandies(status, candies, keys, containedBoxes, initialBoxes);
        System.out.println("Maximum candies collected: " + result);
        sc.close();
    }
}