import java.util.*;
// Question Name: Total Characters in String After Transformations I
public class day31_0 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the string (lowercase letters only): ");
    String s = scanner.nextLine();
    System.out.print("Enter the number of transformations (t): ");
    int t = scanner.nextInt();
    int result = lengthAfterTransformations(s, t);
    System.out.println("Length after transformations: " + result);
    scanner.close();
  }
  public static int lengthAfterTransformations(String s, int t) {
    final int MOD = 1_000_000_007;
    int[] count = new int[26];
    for (char c : s.toCharArray()) ++count[c - 'a'];
    while (t-- > 0) {
      int[] newCount = new int[26];
      for (int i = 0; i < 25; i++) newCount[i + 1] = count[i];
      newCount[0] = count[25];
      newCount[1] = (newCount[1] + count[25]) % MOD;
      count = newCount;
    }
    int result = 0;
    for (int c : count) result = (result + c) % MOD;
    return result;
  }
}
