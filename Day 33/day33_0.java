import java.util.*;
// Question Name: Longest Unequal Adjacent Groups Subsequence I
public class day33_0 {

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int last = -1;
        for (int i = 0; i < words.length; i++) {
            if (groups[i] != last) {
                result.add(words[i]);
                last = groups[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] words = new String[n];
        int[] groups = new int[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        System.out.println("Enter the group numbers corresponding to each word:");
        for (int i = 0; i < n; i++) {
            groups[i] = scanner.nextInt();
        }
        List<String> result = getLongestSubsequence(words, groups);
        System.out.println("Longest subsequence with unique adjacent groups:");
        for (String word : result) {
            System.out.println(word);
        }
        scanner.close();
    }
}
