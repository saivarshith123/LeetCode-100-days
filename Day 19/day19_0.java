import java.util.*;
// Question Name: Maximum Number of Tasks You Can Assign
public class day19_0 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int low = 0, high = Math.min(tasks.length, workers.length);
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int taskCount) {
        Deque<Integer> boosted = new ArrayDeque<>();
        int w = workers.length - 1;
        int freePills = pills;
        for (int t = taskCount - 1; t >= 0; t--) {
            int task = tasks[t];
            if (!boosted.isEmpty() && boosted.peekFirst() >= task) {
                boosted.pollFirst();
            } else if (w >= 0 && workers[w] >= task) {
                w--;
            } else {
                while (w >= 0 && workers[w] + strength >= task) {
                    boosted.addLast(workers[w--]);
                }
                if (boosted.isEmpty() || freePills == 0) {
                    return false;
                }
                boosted.pollLast();
                freePills--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        day19_0 assigner = new day19_0();
        System.out.print("Enter number of tasks: ");
        int n = scanner.nextInt();
        int[] tasks = new int[n];
        System.out.println("Enter task difficulties:");
        for (int i = 0; i < n; i++) {
            tasks[i] = scanner.nextInt();
        }
        System.out.print("Enter number of workers: ");
        int m = scanner.nextInt();
        int[] workers = new int[m];
        System.out.println("Enter worker strengths:");
        for (int i = 0; i < m; i++) {
            workers[i] = scanner.nextInt();
        }
        System.out.print("Enter number of pills: ");
        int pills = scanner.nextInt();
        System.out.print("Enter pill strength: ");
        int strength = scanner.nextInt();
        int result = assigner.maxTaskAssign(tasks, workers, pills, strength);
        System.out.println("Maximum number of tasks that can be assigned: " + result);
        scanner.close();
    }
}
