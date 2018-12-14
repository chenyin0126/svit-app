package com.svit.java.l4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {

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
        
        System.out.println(preorderTraversalIterative(node1));
        System.out.println(preorderTraversalRecursive(node1));
        
		
		
		
	}
	
	
	public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root==null) return result;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null) {
        	result.add(root.val);
        	if(root.right!=null) {
        		stack.push(root.right);
        	}
        	root = root.left;
        	if(root==null && !stack.isEmpty()) {
        		root = stack.pop();
        	}
        }
        return result;
    }
	
	
	public static List<Integer> preorderTraversalRecursive(TreeNode node){
		
		List<Integer> res = new ArrayList<>();
		
		if(node==null) {
			return res;
		}
		
		res.add(node.val);
		res.addAll(preorderTraversalRecursive(node.left));
		res.addAll(preorderTraversalRecursive(node.right));
		
		return res;
		
		
		
		
		
		
		
	}
	
	
	
	

}
