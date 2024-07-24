package first;

public class E {

	//멤버변수=전역변수=인스턴스 변수
	int a; //0
	boolean b; //false
	char c; //' '
	double d; //0.0
	float f; //0.0f
	long l;  //0L
	String s; //null
	Point02 pt02; //null
	//기본생성자
	
	public E() {}
	
	//메소드 선언문
	public void md() {
	//지역변수의 자동초기화 값은 없다.
		int A; 
		boolean B;
		char C;
		double D;
		float F;
		long L;
		String S;
		
		System.out.println("▼멤버변수, 전역변수의 자료형에 따른 초기값");
		System.out.println("a의 초기값:" + a);
		System.out.println("b의 초기값:" + b);
		System.out.println("c의 초기값:" + c);
		System.out.println("d의 초기값:" + d);
		System.out.println("f의 초기값:" + f);
		System.out.println("l의 초기값:" + l);
		System.out.println("s의 초기값:" + s);
		System.out.println("\n===========================");
		System.out.println("▼지역변수, 로컬변수의 자료형에 따른 초기값");
		//System.out.println("A의 초기값:" + A);
		//System.out.println("B의 초기값:" + B);
		//System.out.println("C의 초기값:" + C);
		//System.out.println("D의 초기값:" + D);
		//System.out.println("F의 초기값:" + F);
		//System.out.println("L의 초기값:" + L);
		//System.out.println("S의 초기값:" + S);
		
		
		
	}
	
}
