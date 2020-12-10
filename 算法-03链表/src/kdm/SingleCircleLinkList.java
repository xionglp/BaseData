package kdm;

// 单向循环链表
public class SingleCircleLinkList<E> extends AbstractList<E> {
	private Node<E> first;
	
	// 内部类
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(element).append("_").append(next.element);
			return sb.toString();
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
		if (index == 0) {	
			Node<E> newFirst = new Node<>(element, first);
			Node<E> last = (size == 0) ? newFirst : node(size - 1);
			last.next = newFirst;
			first = newFirst;
		} else {
			//获取要添加节点前一个位置的节点对象
			Node<E> previousNode = node(index - 1);
			Node<E> currentNode =  new Node<>(element, previousNode.next);
			previousNode.next = currentNode;
		}
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		Node<E> node = first;
		if (index == 0) {
			if (size == 1) {
				first = null;
			} else {
				Node<E> last = node(size - 1);
				first = first.next;
				last.next = first;
			}
		} else {
			Node<E> previousNode = node(index - 1);
			node = previousNode.next;
			previousNode.next = node.next;
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
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(node);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
}
