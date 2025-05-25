import java.util.Scanner;

public class day3_0 {

    // Fenwick Tree (Binary Indexed Tree) as a static inner class
    static class FenwickTree {
        private int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 1];
        }

        public void update(int index, int delta) {
            index++;
            while (index < tree.length) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            index++;
            int res = 0;
            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }
            return res;
        }
    }

    // Method to count good triplets
    public static long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos2 = new int[n], reversedIndexMapping = new int[n];

        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            reversedIndexMapping[pos2[nums1[i]]] = i;
        }

        FenwickTree tree = new FenwickTree(n);
        long res = 0;

        for (int value = 0; value < n; value++) {
            int pos = reversedIndexMapping[value];
            int left = tree.query(pos);
            tree.update(pos, 1);
            int right = (n - 1 - pos) - (value - left);
            res += (long) left * right;
        }

        return res;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the arrays: ");
        int n = scanner.nextInt();

        int[] nums1 = new int[n];
        System.out.println("Enter " + n + " elements for nums1 (space-separated, 0 to " + (n - 1) + "):");
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }

        int[] nums2 = new int[n];
        System.out.println("Enter " + n + " elements for nums2 (space-separated, 0 to " + (n - 1) + "):");
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }

        long result = goodTriplets(nums1, nums2);
        System.out.println("Number of good triplets: " + result);

        scanner.close();
    }
}
