package kdm.list;

@SuppressWarnings("unchecked")
public class ArrayList<E>  extends AbstractList<E> {
	// 所有的元素
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (E[]) new Object[capacity];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY); // 无参的构造方法调用有参的构造方法使用this；
	}
	
	// 1、清楚所有的元素
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		trim();
		size = 0;
	}
	
	// 6、获取index位置的对应的元素
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	// 7、设置index位置的元素
	public E set(int index, E element) {
		rangeCheck(index);
		E oldValue = elements[index];
		elements[index] = element;
		return oldValue;
	}
	
	// 8、往index位置添加元素
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
	}
	
	// 9、删除index位置对应的元素
	public E remove(int index) {
		rangeCheck(index);
		E oldValue = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		elements[size] = null;
		trim();
		return oldValue;
	}
	
	// 10、查看元素的位置
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	// 保证有足够的容量
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		int newCapacity = oldCapacity + (oldCapacity >> 1); //新容量是旧容量的1.5倍
		E[] newEelments = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newEelments[i] = elements[i];
		}
		elements = newEelments;
		System.out.println(oldCapacity + "扩容为：" + newCapacity);
	}
	
	// 缩容操作
	private void trim() {
		int oldCapacity = elements.length;
		int newCapacity = elements.length >> 1;
		if (size >= newCapacity || oldCapacity <= DEFAULT_CAPACITY) return;
		E[] newEelments = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newEelments[i] = elements[i];
		}
		elements = newEelments;
		System.out.println(oldCapacity + "缩容为：" + newCapacity);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			 stringBuilder.append(elements[i]);
			 if (i < size - 1) {
				 stringBuilder.append(", ");
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
