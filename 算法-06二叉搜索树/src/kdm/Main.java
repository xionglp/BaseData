package kdm;

import java.util.Comparator;

import printer.BinaryTrees;

public class Main {

//	 private static class personComparator implements Comparator<Person> {
//		@Override
//		public int compare(Person e1, Person e2) {
//			return e1.age - e2.age;
//		}
//	 }
	
	/**
	 * integer类型
	 */
	static void testInteger() {
		Integer data[] = new Integer[] {
			7, 4, 9, 2, 5, 8, 11, 3, 1, 12
		};

		BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst1.add(data[i]);
		}
		BinaryTrees.println(bst1);
		bst1.levelOrderTraversal();
	}
	
	/**
	 * Person对象
	 * @param <T>
	 */
	static <T> void testPerson() {
		Integer data[] = new Integer[] {
			7, 4, 9, 2, 5, 8, 11, 3, 1, 12
		};

		BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
		});
		for (int i = 0; i < data.length; i++) {
			bst1.add(new Person(data[i]));
		}
		BinaryTrees.println(bst1);
	}
	

	static void testMath() {
		BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
		for (int i = 0; i < 30; i++) {
			bst1.add((int)(Math.random() * 100));
		}
		BinaryTrees.println(bst1);
	}

	public static void main(String[] args) {
		
		testInteger();
		
	}

}
