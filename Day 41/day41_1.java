import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
// Question Name: Symmetric Tree
public class day41_1 {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int data){
            this.data = data;
        } 
        TreeNode(int data, TreeNode left, TreeNode rigNode){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static TreeNode buildTree(List<String> nodes) {
        if (nodes == null || nodes.isEmpty() || nodes.get(0).equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < nodes.size()) {
            TreeNode current = queue.poll();
            if (current == null) continue;
            if (i < nodes.size() && !nodes.get(i).equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes.get(i)));
                queue.offer(current.left);
            }
            i++;
            if (i < nodes.size() && !nodes.get(i).equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes.get(i)));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
    public static boolean checkSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.data != rightNode.data) {
            return false;
        }
        boolean leftCheck = checkSymmetric(leftNode.left, rightNode.right);
        boolean rightCheck = checkSymmetric(leftNode.right, rightNode.left);
        boolean check = leftCheck && rightCheck;
        return check;
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree nodes in level-order (use 'null' for empty):");
        String input = sc.nextLine();
        List<String> nodes = Arrays.asList(input.trim().split("\\s+"));
        TreeNode root = buildTree(nodes);
        boolean result = isSymmetric(root);
        System.out.println("Is tree symmetric? " + result);
        sc.close();
    }
}