package kdm;

import kdm.list.LinkList;

// 双端队列
// 可以在首尾俩端进行添加和删除的对列
public class Deque<E> {

	private LinkList<E> linkList = new LinkList<>();
	
	public int size() {
		return linkList.size();
	}

	public boolean isEmpty() {
		return linkList.isEmpty();
	}
	
	public void clear() {
		linkList.clear();
	}
	
	// 队尾入队
	public void enQueueRear(E element) {
		linkList.add(element);
	}
	
	// 队头出队
	public E deQueueFront() {
		return linkList.remove(0);
	}
	
	// 队头入队
	public void enQueueFront(E element) {
		linkList.add(0, element);
	}
	
	// 队尾出队
	public E deQueueRear() {
		return linkList.remove(size() - 1);
	}
	
	// 获取队头元素
	public E frontElement() {
		return linkList.get(0);
	}
	
	// 获取队尾元素
	public E rearElement() {
		return linkList.get(size() - 1);
	}
}
