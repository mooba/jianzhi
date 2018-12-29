package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static List<Integer> rightSideView(TreeNode root) { // 第一中解法，用了太多的数据结构
        List<Integer> retList = new ArrayList<Integer>();
        if (root == null)
            return retList;
        Queue<Helper> queue1 = new LinkedList<Helper>();
        Queue<Helper> queue2 = new LinkedList<Helper>();

        int lev = 0;
        queue1.offer(new Helper(root, lev));
        while(!queue1.isEmpty()) {
            Helper tmp = queue1.poll();
            if (tmp.node.left != null)     
                queue1.offer(new Helper(tmp.node.left, tmp.level + 1));
            if (tmp.node.right != null) 
                queue1.offer(new Helper(tmp.node.right, tmp.level + 1));
            queue2.offer(tmp);
        }

        Helper preNode = queue2.poll();
        while (!queue2.isEmpty()) {
            Helper tmp = queue2.poll();
            int curLevel = tmp.level;
            if (curLevel != preNode.level)
                retList.add(preNode.node.val);
            preNode = tmp;
        }
        retList.add(preNode.node.val); // 最后一个节点
        return retList;
    }

    public static List<Integer> rightSideView2(TreeNode root) {  // 层次遍历，每层先从右边开始遍历
        List<Integer> retList = new ArrayList<Integer>();
        if (root == null)
            return retList;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // retList.add(root.val);
        while (!queue.isEmpty()) {
            int curNodeNum = queue.size();
            boolean addFlag = false; // 当前层是否添加了元素到retList中
            while (curNodeNum > 0) {
                TreeNode tmpNode = queue.poll();
                if (!addFlag) { //每一层的第一个
                    retList.add(tmpNode.val);
                    addFlag = true;
                }

                if (tmpNode.right != null) 
                    queue.offer(tmpNode.right);
                
                if (tmpNode.left != null) 
                    queue.offer(tmpNode.left);
                
                    curNodeNum--;    
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n2.right = n5;
        n1.right = n3;
        n3.right = n4;
        System.out.println(rightSideView2(n1)); 
    }
}

class Helper{
    TreeNode node;
    int level;
    Helper(TreeNode treeNode, int level){
        this.node = treeNode;
        this.level = level;
    }
}