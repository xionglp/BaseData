/* 队列 */
package kdm;

import kdm.list.LinkList;

public class Queue<E> {
	/*
	队列是一种特殊的线性表， 只能在首尾俩端进行操作；
	队尾：只能从队尾添加元素，叫做入队（enQeque）
	对头：只能从对头添加元素，叫做出队（deQueue）
	遵守先进先出的原则；
	*/
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

	//入队列
	public void enQueue(E element) {
		linkList.add(element);
	}

	//出队列
	public E deQueue() {
		return linkList.remove(0);
	}

	//获取队列的头元素
	public E front() {
		return linkList.get(0);
	}

}
