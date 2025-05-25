import java.util.Scanner;
// Question Name: Rabbits in Forest
class day8_0 {
    public int numRabbits(int[] answers) {
        int[] count = new int[1001];
        int totalRabbits = 0;
        for (int answer : answers) count[answer]++;
        for (int answer = 0; answer <= 1000; answer++) {
            if (count[answer] > 0) {
                int groupSize = answer + 1;
                int numOfRabbits = count[answer];
                int groups = numOfRabbits / groupSize;
                if (numOfRabbits % groupSize != 0) groups += 1;
                totalRabbits += groups * groupSize;
            }
        }
        return totalRabbits;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answers = new int[n];
        for (int i = 0; i < n; i++) answers[i] = sc.nextInt();
        System.out.println(new day8_0().numRabbits(answers));
        sc.close();
    }
}
