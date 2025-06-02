import java.util.*;
public class day51_0 {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int totalCandies = n;
        int i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }
            int currentPeak = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                currentPeak++;
                totalCandies += currentPeak;
                i++;
            }
            if (i == n) {
                return totalCandies;
            }
            int currentValley = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                currentValley++;
                totalCandies += currentValley;
                i++;
            }
            totalCandies -= Math.min(currentPeak, currentValley);
        }
        return totalCandies;        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of children: ");
        int a = sc.nextInt();
        int[] ratings = new int[a];
        System.out.println("Enter the ratings: ");
        for(int i=0;i<a;i++){
            ratings[i] = sc.nextInt();
        }
        int result = candy(ratings);
        System.out.println("Minimum number of candies: "+result);
        sc.close();
    }
}