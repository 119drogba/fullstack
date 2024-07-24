package third;

class Method {
	int a = 10, b = 20; // 인스턴스 변수

	// 인스턴스 메소드 = 멤버 메소드
	int add() {
		return a + b;
	}

	// 클래스 메소드
	static int add(int x, int y) {
		return x + y;
	}

}

public class MethodEx {

	public static void main(String[] args) {

		System.out.println(Method.add(20, 30)); // 클래스 메소드의 호출

		Method myMethod = new Method(); // 인스턴스 생성 = 객체 생성
		System.out.println(myMethod.add()); // 인스턴스 메소드의 호출

	}

}
