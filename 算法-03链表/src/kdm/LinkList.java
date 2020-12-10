package kdm;

// 双向链表
public class LinkList <E> extends AbstractList<E> {
	private Node<E> first;
	private Node<E> last;
	
	// 内部类
	private static class Node<E> {
		E element;
		Node<E> prev;
		Node<E> next;
		public Node(Node<E> prev, E element, Node<E> next) {
			super();
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E oldElement = node.element;
		node.element = element;
		return oldElement;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		if (index == size) { // 在双向链表尾部最后一个插入元素
			Node<E> oldLast = last;
			Node<E> node = new Node<>(oldLast, element, null);
			last = node;
			if (oldLast == null) {
				first = last;
			} else {
				oldLast.next = last;
			}
		} else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(prev, element, next);
			if (prev == null) {// 在双向链表头部第一个插入元素
				first = node;
			} else {
				prev.next = node;
			}
			next.prev = node; 
		}
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		if (prev == null) {
			first = prev;
		} else {
			prev.next = next;
		}
		
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
		}
		
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	//获取index位置对应的节点对象
	private Node<E> node (int index) {
		rangeCheck(index);
		if (index < (size >> 1)) { // size >> 1 右移一位， 是size的一半， 相当于size除以2
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}

	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(node.element);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}


}
