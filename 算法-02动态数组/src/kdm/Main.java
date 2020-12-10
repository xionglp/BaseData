package kdm;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(11);
		
		ArrayList<Person> arrayList2 = new ArrayList<>();
		arrayList2.add(new Person("jack", 12));
		arrayList2.add(new Person("rose", 22));
		System.out.println(arrayList2);
		
//		arrayList2.clear();
//		System.gc();//提醒JVM进行垃圾回收
	}

}
