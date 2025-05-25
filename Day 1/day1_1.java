import java.util.Scanner;
// Question name : Solving Question With BrainPower
public class day1_1{
    static long mostPoints(int[][] questions) {
        int length = questions.length;
        long[] maxPoints = new long[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            long points = getPoints(questions, i);
            int brainPower = getBrainPower(questions, i);
            long solve = points + getMaxPoints(maxPoints, i + brainPower + 1);
            long skip = getMaxPoints(maxPoints, i + 1);
            maxPoints[i] = Math.max(solve, skip);
        }
        return maxPoints[0];
    }
    private static long getMaxPoints(long[] maxPoints, int i) {
        if (i >= maxPoints.length) {
            return 0;
        }
        return maxPoints[i];
    }
    private static int getPoints(int[][] questions, int i) {
        return questions[i][0];
    }
    private static int getBrainPower(int[][] questions, int i) {
        return questions[i][1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();
        int[][] questions = new int[n][2];

        System.out.println("Enter questions as two integers per line (points brainpower):");
        for (int i = 0; i < n; i++) {
            questions[i][0] = sc.nextInt(); 
            questions[i][1] = sc.nextInt(); 
        }
        long result = mostPoints(questions);
        System.out.println("Maximum points that can be earned: " + result);
        sc.close();
    }
}