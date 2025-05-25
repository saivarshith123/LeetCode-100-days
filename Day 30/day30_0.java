import java.util.*;
// Question Name: Finding 3-Digit Even Numbers
public class day30_0 {
    public static int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;
        List<Integer> ans = new ArrayList<>();
        for (int a = 1; a < 10; ++a) {
            if (freq[a] == 0) continue;
            freq[a]--;
            for (int b = 0; b < 10; ++b) {
                if (freq[b] == 0) continue;
                freq[b]--;
                for (int c = 0; c < 10; c += 2) {
                    if (freq[c] > 0) ans.add(a*100 + b*10 + c);
                }
                freq[b]++;
            }
            freq[a]++;
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the elments of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] result = findEvenNumbers(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
        sc.close();
    }
}