package kdm;

import java.util.Comparator;

import kdm.printer.BinaryTreeInfo;

// 二叉搜索树
@SuppressWarnings("unchecked")
// extends Comparable<E>
public class BinarySearchTree<E> implements BinaryTreeInfo  {
	private int size;
	private Node<E> rootNode;
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		
	}
	
	// 添加节点
	public void add(E element) {
		elementNotNullCheck(element);
		if (rootNode == null) {
			// 添加的第一个节点（根节点）
			rootNode = new Node<>(element, null);
			size++;
		}
		
		// 添加的不是第一个节点
		Node<E> parent = rootNode;
		Node<E> node = rootNode;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;
			if (cmp > 0) { // 添加的节点大于当前的节点，
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else {
				node.element = element;
				return;
			}
		}
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else if (cmp < 0) {
			parent.left = newNode;
		}
		size++;
	}
	
	// 删除节点
	public void remove(E element) {
		
	}
	
	//是否包含节点
	public boolean contains(E element) {
		return true;
	}
	
	/**
	 * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
	 */
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
		
//		return e1.compareTo(e2);
//		return 0;
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		@SuppressWarnings("unused")
		Node<E> parent;
		
		public Node(E element, Node<E> parentNode) {
			this.element = element;
			this.parent = parentNode;
		}
	}

	@Override
	public Object root() {
		return rootNode;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		return ((Node<E>)node).element;
	}
	
	
}
