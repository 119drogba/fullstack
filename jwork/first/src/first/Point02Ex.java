package first;

public class Point02Ex {
	
	//public static void md() {
	//	System.out.println("md메소드 호출");
	//} 

	public static void main(String[] args) {
		Point02 pt02 = new Point02(100,200);
		System.out.println(pt02.x+","+pt02.y);
		pt02.showPoint();
		
		Point02 pt02_1 = new Point02();
		System.out.println(pt02.x+","+pt02.y);
		pt02_1.showPoint();
		
		//Point02 pt02 = new Point02();
		//자료형 객체명 = new 생성자호출문();
		//동일한 클래스 안에 선언된 메소드는 메소드 이름으로만
		//호출 가능하다.
		//md();
		//다른 클래스 안에 선언된 메소드는 반드시 객체를 생성한 뒤 객체명을 통해 접근 가능하다.
		//pt02.showPoint();
		
		//멤버필드도 객체를 통해 접근 가능하다.
		//pt02.x=5;
		//pt02.y=10;
		//생성자는 객체를 통해서 접근 불가능하다.
//pt02.Point02();
	}

}
