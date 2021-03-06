package kdm;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import printer.BinaryTreeInfo;

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
	 * 前序遍历：顺序->根节点、前序遍历左子树、前序遍历右子树
	 */
	public void preOrder(Visitor<E> visitor) {
		preOrder(visitor, rootNode);
	}
	
	private void preOrder(Visitor<E> visitor, Node<E> node) {
		if (node == null) return; 
		visitor.visit(node.element);
		// 递归调用
		preOrder(visitor, node.left);
		preOrder(visitor, node.right);
	}
	
	/**
	 * 中序遍历：顺序->中序遍历左子树、根节点、中序遍历右子树
	 */
	
	public void inOrder(Visitor<E> visitor) {
		inOrder(visitor, rootNode);
	}
	
	private void inOrder(Visitor<E> visitor, Node<E> node) {
		if (node == null) return;
		inOrder(visitor, node.left);
		visitor.visit(node.element);
		inOrder(visitor, node.right);
	}
	
	/**
	 * 后序遍历：顺序->后序遍历左子树、后序遍历右子树、树根节点、
	 */
	public void postOrder(Visitor<E> visitor) {
		postOrder(visitor, rootNode);
	}
	
	private void postOrder(Visitor<E> visitor, Node<E> node) {
		if (node == null) return;
		postOrder(visitor, node.left);
		postOrder(visitor, node.right);
		visitor.visit(node.element);
	}
	
	/**
	 * 层序遍历：从上到下，从左到右依次遍历每个节点
	 * 实现思路：利用队列
	 * 1、将根节点入队
	 * 2、循环执行以下操作，知道队列为空
	 * a.将队列A的头节点出队，进行访问
	 * b.将A节点的左节点入队（A节点的左节点不为空）
	 * c.将A节点的右节点入队（A节点的右节点不为空）
	 */
	public void levelOrder(Visitor<E> visitor) {
		if (rootNode == null) return;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(rootNode); // 入队
		while (!queue.isEmpty()) {
			 Node<E> node = queue.poll(); // 出队

			 visitor.visit(node.element);
			 
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	/**
	 * 判断是否为完全二叉树
	 */
	public boolean isCompleteSearchTree() {
		if (rootNode == null) return false;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(rootNode);
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) return false;
			
			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) {
				return false;
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			} else {
				leaf = true;
			}
//			if (node.ishasTowChildrenNode()) {
//				queue.offer(node.left);
//				queue.offer(node.right);
//			} else if (node.left == null && node.right != null ) {
//				return false;
//			} else { // 后面遍历的节点都必须是叶子节点
//				leaf = true;
//				if (node.left != null) {
//					queue.offer(node.left);
//				}
//			}
		}
		return true;
	}
	
	/**
	 * 二叉树的高度
	 */
	public int heightTree() {
		if (rootNode == null) return 0;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(rootNode);
		
		// 二叉树的高度
		int height = 0;
		// 二叉树每一层的节点数量
		int levelSize = 1;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize --;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
			
			if (levelSize == 0) { // 意味着即将访问下一层
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}

	/**
	 *  前驱节点: 中序遍历时的前一个节点
	 * @param node
	 * @return
	 */
	private Node<E> predecessor(Node<E> node) {
		
		// 前驱节点在左子树中
		Node<E> preNode = node.left;
		if (node.left != null) {
			while (preNode.right != null) {
				preNode = preNode.right;
			}
			return preNode;
		}
		
		// 从父节点、祖父节点中寻找前驱节点
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		
		return node.parent;
	}

	/**
	 *  后驱节点: 中序遍历时的后一个节点
	 * @param node
	 * @return
	 */
	private Node<E> successor(Node<E> node) {
		
		// 前驱节点在右子树中
		Node<E> preNode = node.right;
		if (node.right != null) {
			while (preNode.left != null) {
				preNode = preNode.left;
			}
			return preNode;
		}
		
		// 从父节点、祖父节点中寻找后驱节点
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		
		return node.parent;
	}
	
	//公共内部接口
	public static interface Visitor<E> {
		void visit(E element);
	}
	
	/**
	 * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
	 */
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
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
		Node<E> parent;
		
		public Node(E element, Node<E> parentNode) {
			this.element = element;
			this.parent = parentNode;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		public boolean ishasTowChildrenNode( ) {
			return left != null && right != null;
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
