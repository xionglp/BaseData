package 栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @author xlp
 *
 */
public class _225_用队列实现栈 {
	
	private Queue<Integer> queue1 = new LinkedList<>();
//	private Queue<Integer> queue2;
	
    /** Initialize your data structure here. */
    public _225_用队列实现栈() {
//    	queue1 = new LinkedList<>();
//    	queue2 = new LinkedList<>(); // 辅助
    }
    
    /** Push element x onto stack. */
    /**
     * 用队列实现栈
     * 栈的特性是后进先出，为了满足栈的特性，最后入栈的元素最先出栈。使用队列实现栈时，需要满足前端的元素是最后入栈的；
     * 解法2：使用一个队列，先将元素入队到队列中， 再将前n个元素的队列出队，然后再入到到队列中；
     * 解法2：使用俩个队列， 先将元素入队到queue2，将queue1的元素依次出队并入队到queue2，再将queue1和queue2互换。
     * @param x
     */
    // 栈：  1， 2， 3
    // 队列： 3， 2， 1
    public void push(int x) {
    	// 解法1
    	queue1.add(x);
    	for (int i = 0; i < queue1.size() - 1; i++) {
			queue1.add(queue1.poll());
		}
    	
    	// 解法2
    	/*
    	queue2.add(x);
    	while (!queue1.isEmpty()) {
			queue2.add(queue1.poll());
		}
    	Queue<Integer> temp = queue1;
    	queue1 = queue2;
    	queue2 = temp;
    	*/
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	// 列表的最后一个元素
    	return queue1.poll();
    }
    
    /** Get the top element. */
    public int top() {
    	return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return queue1.isEmpty();
    }

}
