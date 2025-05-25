import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
// Question Name: Path Sum
public class day42_1 {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode () {}
        TreeNode (int data){
            this.data = data;
        }
        TreeNode (int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean PathSum(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null) {
            return targetSum == root.data;
        }
        boolean leftSum = PathSum(root.left , targetSum - root.data);
        boolean rightSum = PathSum(root.right , targetSum - root.data);
        boolean result = leftSum || rightSum;
        return result;
    }

    public static TreeNode buildTreeFromList(List<String> nodes) {
        if (nodes.size() == 0 || nodes.get(0).equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.size()) {
            TreeNode current = queue.poll();
            if (i < nodes.size() && !nodes.get(i).equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes.get(i)));
                queue.add(current.left);
            }
            i++;
            if (i < nodes.size() && !nodes.get(i).equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes.get(i)));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replaceAll("[\\[\\]\\s]", "");
        List<String> nodeValues = Arrays.asList(input.split(" "));
        TreeNode root = buildTreeFromList(nodeValues);
        int targetSum = sc.nextInt();
        boolean result = PathSum(root, targetSum);
        if(result){
            System.out.println("There exists a root-to-leaf path with the given sum.");
        } else {
            System.out.println("No root-to-leaf path found with the given sum.");
        }
        sc.close();
    }
}
