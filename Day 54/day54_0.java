import java.util.Scanner;
// Question Name: Lexicographically Smallest Equivalent String
public class day54_0 {
    static class UnionFind {
        static int[] id;
        public static void init(int n) {
            id = new int[n];
            for (int i = 0; i < n; ++i) {
                id[i] = i;
            }
        }
        public static void union(int u, int v) {
            int i = find(u), j = find(v);
            if (i > j) {
                id[i] = j;
            } else {
                id[j] = i;
            }
        }
        public static int find(int u) {
            if(id[u] == u) {
                return u;
            } else {
                id[u] = find(id[u]);
                return id[u];
            }
        }
    }
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder sb = new StringBuilder();
        UnionFind.init(26);
        for (int i = 0; i < s1.length(); ++i) {
            UnionFind.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        for (char c : baseStr.toCharArray()) {
            sb.append((char) ('a' + UnionFind.find(c - 'a')));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter s1: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter s2: ");
        String s2 = scanner.nextLine();
        System.out.print("Enter baseStr: ");
        String baseStr = scanner.nextLine();
        System.out.println("Smallest Equivalent String: " + smallestEquivalentString(s1, s2, baseStr));
        scanner.close();
    }
}
