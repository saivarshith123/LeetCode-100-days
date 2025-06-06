import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class day55_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String word = sc.nextLine();
        String result = robotWithString(word);
        System.out.println(result);
        sc.close();
    }
    public static String robotWithString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            int ch = c - 'a';
            freq[ch]--;
            stack.push(ch);
            while (!stack.isEmpty() && !hasSmaller(stack.peek(), freq)) {
                result.append((char) (stack.pop() + 'a'));
            }
        }
        return result.toString();
    }
    private static boolean hasSmaller(int top, int[] freq) {
        for (int i = 0; i < top; i++) {
            if (freq[i] > 0) return true;
        }
        return false;
    }
}