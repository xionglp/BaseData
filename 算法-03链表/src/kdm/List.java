package kdm;

// 接口
public interface List<E> {
		static final int ELEMENT_NOT_FOUND = -1;
		// 1、清楚所有的元素
		void clear();
		
		// 2、元素的数量
		int size();
		
		// 3、是否为空
		boolean isEmpty();
		
		// 4、是否包含某个元素
		boolean isContains(E element);
		
		// 5、添加元素到最后面
		void add(E element);
		
		// 6、获取index位置的对应的元素
		E get(int index);
		
		// 7、设置index位置的元素
		E set(int index, E element);
		
		// 8、往index位置添加元素
		void add(int index, E element);
		
		// 9、删除index位置对应的元素
		E remove(int index);
		
		// 10、查看元素的位置
		int indexOf(E element);
}
