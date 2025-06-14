import java.util.*;
// Question Name: Maximum Difference by Remapping a Digit
public class day63_0 {
    public static int minMaxDifference(int num) {
        String str = Integer.toString(num);
        char[] maxChars = str.toCharArray();
        char[] minChars = str.toCharArray();
        char replaceForMax = ' ';
        for (char c : maxChars) {
            if (c != '9') {
                replaceForMax = c;
                break;
            }
        }
        for (int i = 0; i < maxChars.length; i++) {
            if (maxChars[i] == replaceForMax) {
                maxChars[i] = '9';
            }
        }
        char replaceForMin = minChars[0];
        for (int i = 0; i < minChars.length; i++) {
            if (minChars[i] == replaceForMin) {
                minChars[i] = '0';
            }
        }
        int maxVal = Integer.parseInt(new String(maxChars));
        int minVal = Integer.parseInt(new String(minChars));
        int result = maxVal - minVal;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        int num = minMaxDifference(n);
        System.out.println("Difference between the maximum and minimum values: "+num);
        sc.close();
    }
}