package kdm;

// 循环双端队列
@SuppressWarnings("unchecked")
public class CircleDeque<E> {
	private int frontIndex = 0; // 队头下标
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public CircleDeque() {
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
	
	// 队尾入队
	public void enQueueRear(E element) {
		ensureCapacity(size + 1);
		elements[index(size)] = element;
		size++;
	}
	
	// 队头出队
	public E deQueueFront() {
		E frontElement = elements[frontIndex];
		elements[frontIndex] = null;
		frontIndex = index(1);
		size--;
		return frontElement;
	}
	
	// 队头入队
	public void enQueueFront(E element) {
		ensureCapacity(size + 1);
		frontIndex = index(-1);
		elements[frontIndex] = element;
		size++;
	}
	
	// 队尾出队
	public E deQueueRear() {
		E frontElement = elements[index(size - 1)];
		elements[index(size - 1)] = null;
		size--;
		return frontElement;
	}
	
	// 获取队头元素
	public E frontElement() {
		return elements[frontIndex];
	}
	
	// 获取队尾元素
	public E rearElement() {
		return elements[index(size() - 1)];
	}
	
	// 封装索引的下标
	private int index(int index) {
		index += frontIndex;
		if (index < 0) {
			return index + elements.length;
		}
		return index % elements.length;
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
