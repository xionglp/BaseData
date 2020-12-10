package 链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author xiongluping
 */
public class _141_环形列表 {
	
	/**
	 * 解题思路：快慢指针
	 * 慢的指针走一步， 快的指针走俩步， 
	 * 当快指针和慢指针相等（重合）的时候，说明有链表有环， 
	 * 如果快指针指向空，说明链表没有环
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) { //还没有指向null的时候就一直往前走俩步
			if (slow.equals(fast)) return true;
			slow = slow.next;
			fast = fast.next.next;
		}
        return false;
    }
}
