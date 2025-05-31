import java.util.Scanner;
import java.util.Arrays;
// Question Name: Find Closest Node to Given Two Nodes
public class day48_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();
        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            edges[i] = scanner.nextInt();
        }
        System.out.print("Enter node1: ");
        int node1 = scanner.nextInt();
        System.out.print("Enter node2: ");
        int node2 = scanner.nextInt();
        int result = closestMeetingNode(edges, node1, node2);
        System.out.println("Closest meeting node: " + result);
        scanner.close();
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = getDistances(edges, node1);
        int[] dist2 = getDistances(edges, node2);
        int result = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistance) {
                    minDistance = maxDist;
                    result = i;
                }
            }
        }
        return result;
    }

    public static int[] getDistances(int[] edges, int start) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int d = 0;
        while (start != -1 && dist[start] == -1) {
            dist[start] = d++;
            start = edges[start];
        }
        return dist;
    }
}
