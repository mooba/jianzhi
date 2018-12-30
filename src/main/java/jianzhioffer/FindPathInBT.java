package jianzhioffer;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
import java.util.ArrayList;
import java.util.LinkedList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class FindPathInBT {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return listAll;

        FindPathHelper(root, target);
        return listAll;
    }

    public void FindPathHelper(TreeNode root, int target) { // 使用深度优先遍历
        list.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
        }

        if (root.left != null && target > root.val) {
            FindPathHelper(root.left, target - root.val);
        }

        if (root.right != null && target > root.val) {
            FindPathHelper(root.right, target - root.val);
        }

        list.remove(list.size() - 1);
        return;
    }
    
}