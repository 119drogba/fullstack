package second;

public class Student {

	private int apple;
	private int straw;
	private int grapes;
	private int sum;

	public Student() {
		this(0,0,0);
	}
	
	public Student (int ap, int st, int gr) {
		apple = ap;
		straw = st;
		grapes = gr;
		this.count(); // this 생략가능
	}

	private void count() { // 메소드 선언문
		sum = apple + straw + grapes;

	}

	public int getApple() {
		return apple;
	}

	public int getStraw() {
		return straw;
	}

	public int getGrapes() {
		return grapes;
	}

	public int getSum() {
		return sum;

	}

}
