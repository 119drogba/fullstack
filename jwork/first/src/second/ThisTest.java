package second;

public class ThisTest {
	int x,y;
	
	public ThisTest() {
		this(10,10);   //다른 생성자 호출 매개변수 같은 곳으로
	}
	
	public ThisTest(int x) {
		this (x,10);
	}
	
	public ThisTest(int x, int y) {
		
		this.x=x;
		this.y=y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void showPoint() {
		System.out.println(x+ ","+y);
	}

}
