package com.svit.java.l4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node4.left = node7;

		 System.out.println(postorderTraversalIterative(node1));
		System.out.println(postorderTraversalRecursive(node1));

	}

	public static List<Integer> postorderTraversalIterative(TreeNode root) {

		LinkedList<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				result.addFirst(p.val); // Reverse the process of preorder
				p = p.right; // Reverse the process of preorder
			} else {
				TreeNode node = stack.pop();
				p = node.left; // Reverse the process of preorder
			}
		}
		return result;

	}

	public static List<Integer> postorderTraversalRecursive(TreeNode node) {
		List<Integer> res = new ArrayList<>();
		if (node == null) {
			return res;
		}
		res.addAll(postorderTraversalRecursive(node.left));
		res.addAll(postorderTraversalRecursive(node.right));
		res.add(node.val);
		return res;
	}

}
