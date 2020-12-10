package kdm;
//无参的构造方法调用有参的构造方法使用this；

public class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		
		super.finalize();
		System.out.println("person - finalze");
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if (obj == null) return false;
		if (obj instanceof Person) {
			Person person = (Person)obj;
			return this.age == person.age;
		}
		return false;
	}
	
	

}
