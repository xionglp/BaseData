package kdm;

// abstract 抽象类，（可以不全部实现接口的函数）
public abstract class  AbstractList<E> implements List<E> {

	// 元素的数量
	protected int size;
	
	public int size() {
		return size;
	}
	
	// 3、是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	// 4、是否包含某个元素
	public boolean isContains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	// 5、添加元素到最后面
	public void add(E element) {
		add(size, element);
	}
	
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			System.out.println("index: "  +  index);
			System.out.println("size: "  +  size);
			throw new IndexOutOfBoundsException("index索引超过数组的长度");// 抛出异常
		}
	}
	
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index索引超过数组的长度");// 抛出异常
		}
	}
}
