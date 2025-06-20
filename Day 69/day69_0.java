import java.util.Scanner;
// Question Name: Maximum Manhattan Distance After K Changes
public class day69_0 {
    public static int maxDistance(String s, int k) {
        int ans = 0;
        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;
        int length = s.length();
        for(int i=0;i<length;i++) {
            char ch = s.charAt(i);
            if(ch == 'N') {
                north ++;
            } else if(ch == 'S') {
                south ++;
            } else if(ch == 'E') {
                east ++;
            } else if(ch == 'W') {
                west ++;
            }
            int x = Math.abs(north - south);
            int y = Math.abs(east - west);
            int MD = x + y;
            int dis = MD + Math.min(2 * k, i + 1 - MD);
            ans = Math.max(ans, dis);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the direction string (only N, S, E, W): ");
        String s = sc.nextLine().toUpperCase(); 
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        int result = maxDistance(s, k);
        System.out.println("Maximum Distance: " + result);
        sc.close();
    }
}
