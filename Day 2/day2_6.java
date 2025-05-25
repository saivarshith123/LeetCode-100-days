import java.util.Scanner;
// Question name: Distributing items when a person cannot take more than two items of same type
public class day2_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sweets array (space-separated):");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] sweets = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            sweets[i] = Integer.parseInt(inputArray[i]);
        }
        System.out.println("Enter the number of customers:");
        int k = scanner.nextInt();
        boolean isPossible = true;
        for (int i = 0; i < sweets.length; i++) {
            int count = 0;
            for (int j = 0; j < sweets.length; j++) {
                if (sweets[i] == sweets[j]) {
                    count++;
                }
            }
            if (count > 2 * k) {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        scanner.close();
    }
}
