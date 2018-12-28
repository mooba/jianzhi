package jianzhioffer;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

// Definition for binary tree
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int prelen = pre.length;
        int inlen = in.length;
        if (prelen != inlen || 0 == prelen || 0 == inlen) {
            return null;
        }

        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < inlen; i ++) {
            if (in[i] == rootVal){
                rootIndex = i;
                break;
            }
        }

        int[] preLeft = new int[rootIndex],
              preRight = new int[prelen - rootIndex - 1],
              inLeft = new int[rootIndex],
              inRight = new int[inlen - rootIndex - 1];


        for (int i = 0; i < inlen; i++) {
            if (i < rootIndex) {
                inLeft[i] = in[i];
                preLeft[i] = pre[i + 1];
            } else if (i > rootIndex){
                inRight[i - rootIndex - 1] = in[i];
                preRight[i - rootIndex - 1] = pre[i]; 
            }
        }
        
        root.left = reConstructBinaryTree(preLeft, inLeft);
        root.right = reConstructBinaryTree(preRight, inRight);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        ReConstructBinaryTree solution4 = new ReConstructBinaryTree();
        TreeNode root = solution4.reConstructBinaryTree(pre, in);
        System.out.println(root.val);
    }
}