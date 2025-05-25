import java.util.Scanner;
// Question Name: Length Of The Last Word
public class day5_3 {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        return words[words.length - 1].length();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        day5_3 obj = new day5_3();
        int result = obj.lengthOfLastWord(input);
        System.out.println("Length of the last word: " + result);
        scanner.close();
    }
}
