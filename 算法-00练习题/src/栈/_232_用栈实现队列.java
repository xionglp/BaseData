package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @author xlp
 *
 */
public class _232_用栈实现队列 {
	
	/**
	 * 准备俩个栈inStack,outStack
	 * 入队：push到inStack中
	 * 出队：1、如果outStack为空，将inStack所有的元素逐一弹出，并push到outStack中，弹出outStack栈顶元素
	 * 2、如果outStack不为空，弹出outStack栈顶元素
	 */
	private Stack<Integer> inStack;
	private Stack<Integer> outStack;
	
    /** Initialize your data structure here. */
    public _232_用栈实现队列() {
    	inStack = new Stack<>();
    	outStack = new Stack<>();
    }
    
    /** 入队 */
    public void push(int x) {
    	inStack.push(x);
    }
    
    /** 出队 */
    public int pop() {
    	if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
    	return outStack.pop();
    }
    
    /** 获取队头元素*/
    public int peek() {
    	if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
    	return outStack.peek();
    }
    
    /** 队列是否为空*/
    public boolean empty() {
    	return inStack.isEmpty() && outStack.isEmpty();
    }
}
