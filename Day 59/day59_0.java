import java.util.*;
// Question Name: Maximum Difference Between Even and Odd Frequency I
public class day59_0 {
    public static int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int odd = 0;
        int even = s.length();
        for (int n : freq) {
            if ((n & 1) == 1) {
                odd = Math.max(odd, n);
            } else if (n != 0) {
                even = Math.min(even, n);
            }
        }
        return odd - even;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a lowercase string: ");
        String s = scanner.nextLine();
        scanner.close();
        int result = maxDifference(s);
        System.out.println("Max difference: " + result);
    }
}
