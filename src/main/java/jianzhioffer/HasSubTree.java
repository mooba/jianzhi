package jianzhioffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubTree {
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                result = hasSubtreeHelper(root1, root2);  
            if (!result)
                result = hasSubtree(root1.left, root2);
            if (!result)
                result = hasSubtree(root1.right, root2);
            
        }

        return result;
    }

    public static boolean hasSubtreeHelper(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;
        
        if (root1.val != root2.val)
            return false;
        
        return hasSubtreeHelper(root1.left, root2.left) && hasSubtreeHelper(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;
        n5.right = n7;

        TreeNode sub1 = new TreeNode(2);
        TreeNode sub2 = new TreeNode(4);
        TreeNode sub3 = new TreeNode(5);
        sub1.left = sub2;
        sub1.right = sub3;

        System.out.println(hasSubtree(n1, sub1));
    }
}