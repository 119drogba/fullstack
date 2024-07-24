package first;

public class Overloadex {
	
	public static void main (String [] args) {
		Overload ob = new Overload();
		double result;
		ob.test();
		ob.test(5,10);
		
		//자동형변환을 거쳐 void test(double a)를 실행
		result = ob.test(100);
		
		System.out.println("ob.test(100)의 결과:" + result);
		result = ob.test(4.2);
	}

}
