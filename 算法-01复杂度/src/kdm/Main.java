package kdm;

import kdm.Times.Task;

public class Main {

	public static void main(String[] args) {
		Times.test("fib", new Task() {
			@Override
			public void execute() {
				System.out.println(fib(45));
				
			}
		});
		Times.test("fib2", new Task() {
			@Override
			public void execute() {
				System.out.println(fib2(45));
				
			}
		});

	}
	
	/**
	 * 计算斐波那契数列
	 * 0 1 2 3 4 5 6
	 * 0 1 1 2 3 5 8
	 */
	public static int fib(int n) {
		if (n <= 1) return n;
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	public static int fib2(int n) {
		if (n <= 1) return n;
		return fib2(n - 1) + fib2(n - 2);
	}

}
