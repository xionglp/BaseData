package 链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {
	
	/**
	 * 删除链表中的节点:
	 * 由于拿不到当前节点的上一个节点， 可以根据当前节点拿到下一个节点，
	 * 将下一个节点的值覆盖掉当前节点的值， 
	 * 再将下一个节点删掉（当前节点指向下一个节点的下一个节点）
	 */
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    } 
	
}
