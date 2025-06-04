import java.util.Scanner;
// Question Name: Find the Lexicographically Largest String From the Box I
public class day53_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String word = scanner.nextLine();
        System.out.print("Enter the number of friends: ");
        int numFriends = scanner.nextInt();
        day53_0 obj = new day53_0();
        String answer = obj.answerString(word, numFriends);
        System.out.println("Lexicographically largest string from the box: " + answer);
        scanner.close();
    }
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        int len = n - numFriends + 1;
        char maxChar = 'a';
        for (char ch : word.toCharArray()) {
            if (ch > maxChar) {
                maxChar = ch;
            }
        }
        String result = "";
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == maxChar) {
                if (i + len <= n) {
                    String sub = word.substring(i, i + len);
                    if (sub.compareTo(result) > 0) {
                        result = sub;
                    }
                } else {
                    String sub = word.substring(i);
                    if (sub.compareTo(result) > 0) {
                        result = sub;
                    }
                }
            }
        }
        return result;
    }
}
