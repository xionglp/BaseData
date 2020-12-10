package kdm;

//循环队列
@SuppressWarnings("unchecked")
public class CircleQueue<E> {
	private int frontIndex = 0; // 队头下标
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[index(i)] = null;
		}
		size = 0;
		frontIndex = 0;
	}

	//入队列
	public void enQueue(E element) {
		ensureCapacity(size + 1);
//		elements[(frontIndex + size) % elements.length] = element;
		elements[index(size)] = element;
		size++;
	}

	//出队列
	public E deQueue() {
		E frontElement = elements[frontIndex];
		elements[frontIndex] = null;
//		frontIndex = (frontIndex + 1) % elements.length;
		frontIndex = index(1);
		size--;
		return frontElement;
	}

	//获取队列的头元素
	public E front() {
		return elements[frontIndex];
	}
	
	// 封装索引的下标
	private int index(int index) {
		return (frontIndex + index) % elements.length;
	}

	// 保证有足够的容量
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		int newCapacity = oldCapacity + (oldCapacity >> 1); //新容量是旧容量的1.5倍
		E[] newEelments = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newEelments[i] = elements[index(i)];
		}
		elements = newEelments;
		frontIndex = 0;
		System.out.println(oldCapacity + "扩容为：" + newCapacity);
	}

	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capcacity=").append(elements.length)
		.append(" size=").append(size)
		.append(" front=").append(frontIndex)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
}
