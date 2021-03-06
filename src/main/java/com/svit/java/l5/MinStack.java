package com.svit.java.l5;
/**
 * @author sv-it
 */
import java.util.Stack;

public class MinStack {
	   int min = Integer.MAX_VALUE;
	    Stack<Integer> stack = new Stack<Integer>();
	    public void push(int x) {
	        // only push the old minimum value when the current 
	        // minimum value changes after pushing the new value x
	        if(x <= min){          
	            stack.push(min);
	            min=x;
	        }
	        stack.push(x);
	        System.out.println(stack);
	       
	    }

	    public void pop() {
	        // if pop operation could result in the changing of the current minimum value, 
	        // pop twice and change the current minimum value to the last minimum value.
	        if(stack.pop() == min) {
	        	min=stack.pop();
	        }
//	        System.out.println(min);
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return min;
	    }
	    
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(0);
		minStack.push(-1);
//		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> Returns -1.
		minStack.pop();
//		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   //--> Returns -2.
	}

}
