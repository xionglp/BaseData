package kdm;

public class Main {

	public static void main(String[] args) {
//		List<Integer> arrayList = new ArrayList<>();
//		arrayList.add(11);
		
//		List<Integer> arrList = new ArrayList<>();
//		for (int i = 0; i < 50; i++) {
//			arrList.add(i);
//		}
//		System.out.println(arrList);
//		
//		for (int i = 0; i < 50; i++) {
//			arrList.remove(0);
//		}
//		System.out.println(arrList);
		
//		List<Integer> linkList = new SingleLinkList<>(); //单向链表
//		linkList.add(20);
//		linkList.add(0, 10);
//		linkList.add(30);
//		linkList.add(linkList.size(), 40);
//		linkList.remove(1);
//		linkList.add(55);
//		System.out.println(linkList);
		
//		List<Integer> list = new LinkList<>(); // 双向链表
//		list.add(20);
//		list.add(0, 10);
//		list.add(30);
//		list.add(list.size(), 40);
//		list.remove(1);
//		list.add(55);
//		System.out.println(list);
		
		List<Integer> list = new SingleCircleLinkList<>(); // 单向循环链表
		list.add(20);
		list.add(0, 10);
		list.add(30);
		list.add(list.size(), 40);
		list.remove(1);
		list.add(55);
		System.out.println(list);
		
	}

}
