package third;

public class Counter {
	int b =5;
	static int count = 0;


	Counter() { // 생성자는 기타제어자를 쓸 수 없다.
		this.count++;
	}
	public void md() {
		System.out.println(b);
		System.out.println(count);
	}

	public static int getCount() {
		final int c =5;
		System.out.println(c);
		System.out.println(count);
		
	
		return count;
		
	}

}
