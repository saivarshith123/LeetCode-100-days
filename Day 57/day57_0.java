import java.util.*;
// Question Name: Lexicographical Numbers
public class day57_0 {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < n; i++) {
            result.add(count);
            if (count * 10 <= n) {
                count *= 10;
            } else {
                if (count >= n) count /= 10;
                count++;
                while (count % 10 == 0) {
                    count /= 10;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();
        scanner.close();
        List<Integer> result = lexicalOrder(n);
        System.out.println("Lexicographical order from 1 to " + n + ":");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
