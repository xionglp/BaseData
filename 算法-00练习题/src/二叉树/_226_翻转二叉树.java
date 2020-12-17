package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _226_翻转二叉树 {
//	public TreeNode invertTree(TreeNode root) {
//		
//		// 前序遍历
//		if (root == null) return null;
//		TreeNode tmpNode = root.left;
//		root.left = root.right;
//		root.right = tmpNode;
//		
//		invertTree(root.left);
//		invertTree(root.right);
//		
//		return root;
//    }
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll(); // 出队
			
			TreeNode tmpNode = node.left;
			node.left = node.right;
			node.right = tmpNode;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		
		return root;
    }
}
