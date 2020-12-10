package kdm;

import kdm.list.ArrayList;

public class Stack<E>  {
	// 利用组合，将链表作为栈的一部分
	private ArrayList<E> arrayList = new ArrayList<E>();
	
	//1.清空栈
	public void clear() {
		arrayList.clear();
	}
	
	// 2.栈的元素个数
	public int size() {
		return arrayList.size();
	}
	
	//3.是否为空 
	public boolean isEmpty() {
		return arrayList.isEmpty();
	}
	
	//4.入栈
	public void push(E element) {
		arrayList.add(element);
	}
	
	//5.出栈
	public E pop() {
		return arrayList.remove(arrayList.size() - 1);
	}

	//6.获取栈顶的元素
	public E top() {
		return arrayList.get(arrayList.size() - 1);
	}
	
	
}
