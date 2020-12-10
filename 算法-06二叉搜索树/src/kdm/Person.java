package kdm;

public class Person implements Comparable<Person>{
	int age;

	public Person(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person e) {
		// 假定age大的 person就大	
//		if (this.age > e.age) return 1;
//		if (this.age < e.age) return -1;
//		return 0;
		return age - e.age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return age + "";
	}
	

}
