package interfaceex;

public class CalcCha1 implements Calc {

	public void add(int a, String s) {

		System.out.println("문자열 결합 연산시작");
		System.out.println(s + a);

	}

	public void minus(int a) {
		System.out.println("뺄셈");
		System.out.println(10-a);
	}

	public void multi(int a) {
		System.out.println("곱하기");
		System.out.println(7 * a);
	}

	public void divi(int a) {
		System.out.println("나누기 나머지 구하기");
		System.out.println(50 / a);
	}
}
