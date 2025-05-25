import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Question Name: Find Words Containing Character
public class day42_0 {
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            if (words[i].indexOf(x) != -1) {
                list.add(i);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the string array: ");
        int n = sc.nextInt();
        sc.nextLine();  
        String[] arr = new String[n];
        System.out.println("Enter the words in order one by one:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.print("Enter the character that you need to check: ");
        char aa = sc.next().charAt(0);
        List<Integer> result = findWordsContaining(arr, aa);
        System.out.println("Indices of words containing '" + aa + "': " + result);
        sc.close();
    }
}
