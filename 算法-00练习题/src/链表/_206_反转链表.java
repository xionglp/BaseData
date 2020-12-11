package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author xiongluping
 * 1111111
 */
public class _206_反转链表 {

	/**
	 * 递归方式
	 * 递归的思路就是利用结果导向过程
	 * 思考reverseList能做什么事情
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newHead = reverseList(head.next); 
		head.next.next = head;
		head.next = null;
		return newHead;
    }

	/**
	 * 非递归的方式(迭代)
	 */
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newHead = null; //1、默认创建一个新的空链表
		while (head != null) {
			ListNode tempList = head.next; //临时节点指向下一个节点
			//head.next指向新创建的newHead列表（第一次是指向null， 下次是指向上一次存放的节点，相当于就倒过来了）
			head.next = newHead; 
			newHead = head;  // 这一步的head只有当前的节点（一个值） 
			head = tempList; // 原先head列表指向 之前临时节点指向的值
		}
		return newHead;
    }

}
