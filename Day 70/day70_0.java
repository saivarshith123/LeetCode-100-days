import java.util.Scanner;
// Question Name: Minimum Deletions to Make String K-Special
public class day70_0 {
    public static int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int base = 0; base < 26; base++) {
            if (freq[base] == 0)
                continue;
            int del = 0;
            int baseFreq = freq[base];
            for (int comp = 0; comp < 26; comp++) {
                if (freq[comp] == 0)
                    continue;
                if (base == comp)
                    continue;
                int compFreq = freq[comp];
                if (compFreq < baseFreq) {
                    del += compFreq;
                } else if (compFreq - baseFreq > k) {
                    del += compFreq - baseFreq - k;
                }
            }
            ans = Math.min(ans, del);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter te string: ");
        String word = sc.nextLine();
        System.out.print("Enter the integer: ");
        int k = sc.nextInt();
        int result = minimumDeletions(word, k);
        System.out.println("Minimum number of characters you need to delete to make word k-special: "+result);
        sc.close();
    }
}
