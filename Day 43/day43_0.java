import java.util.Scanner;
// Question Name: Longest Palindrome by Concatenating Two Letter Words
public class day43_0 {
    public static int longestPalindrome(String[] words) {
        int[][] freq = new int[26][26];
        for (String word : words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
            freq[a][b]++;
        }
        int length = 0;
        boolean centralUsed = false;
        for (int i = 0; i < 26; i++) {
            if (freq[i][i] > 0) {
                int pairs = freq[i][i] / 2;
                length += pairs * 4;
                freq[i][i] -= pairs * 2;
                if (!centralUsed && freq[i][i] > 0) {
                    length += 2;
                    centralUsed = true;
                }
            }
            for (int j = i + 1; j < 26; j++) {
                int pairs = Math.min(freq[i][j], freq[j][i]);
                length += pairs * 4;
            }
        }
        return length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the strings array: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        System.out.println("Enter the words with the length of 2:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }
        int result = longestPalindrome(words);
        System.out.println("Longest possible palindrome length: " + result);
        sc.close();
    }
}
