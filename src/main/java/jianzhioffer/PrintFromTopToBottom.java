package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class PrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (root == null)
            return arrayList;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            arrayList.add(curNode.val);
            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
        }

        return arrayList;
    }
}