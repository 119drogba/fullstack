package second;

public class MyDateEx {

	public static void main (String [] args ) {
		MyDate md = new MyDate(32,5,2024);
		MyDate md1 = new MyDate(32,5,2024);
		MyDate md2 = md;
		//private 멤버필드인데, MyDateEx클래스에서
		//접근하려고 하여 에러 발생
		int a= 5;   //오른쪽을 왼쪽에 넣어라 대입 연산자
		int b= 5;
		int c= 15;
		System.out.println( a== b);     //변수비교
		System.out.println( md == md1 );  //객체비교
		System.out.println( md == md2 );
		
		//	md.y = 50;    //에러
	}
}
