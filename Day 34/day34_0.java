import java.util.*;
// Question Name: Longest Unequal Adjacent Groups Subsequence II
public class day34_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        String[] words = new String[n];
        int[] groups = new int[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        System.out.println("Enter the group numbers:");
        for (int i = 0; i < n; i++) {
            groups[i] = scanner.nextInt();
        }
        List<String> result = getWordsInLongestSubsequence(words, groups);
        System.out.println("Longest unequal adjacent groups subsequence:");
        for (String word : result) {
            System.out.println(word);
        }
        scanner.close();
    }
    public static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxLen = 1;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    hammingDistance(words[i], words[j]) == 1) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }

        LinkedList<String> result = new LinkedList<>();
        int current = endIndex;
        while (current != -1) {
            result.addFirst(words[current]);
            current = prev[current];
        }
        return result;
    }

    private static int hammingDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}
