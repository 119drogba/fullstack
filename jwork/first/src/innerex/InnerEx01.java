package innerex;

class Outer {
	int data = 0;
	static int data1 = 50;

	void myMethod() {
		System.out.println("Outer 클래스의 메소드 data: " + data);
	}

	// 내부클래스 1 - 멤버 이너 클래스
	class InstanceInner {
		int iv = 100;

		void myMethod() {
			System.out.println("InstanceInner 클래스의 메소드 data : " + data + ",iv: " + iv);
		}
	}

	// 내부클래스 2 - 정적 클래스
	static class StaticInner {
		int iv = 200;
		static int cv = 300;

		void myMethod() {
			System.out.println("StaticInner 클래스의 메소드 data1 : " + data1);
//			System.out.println("StaticInner 클래스의 메소드 data1 : "+data);
//			클래스 외부 데이터인 경우는 static만 올 수 있다.
			System.out.println("StaticInner 클래스의 iv : " + iv + ",cv:" + cv);

		}
	}
}

public class InnerEx01 {

	public static void main(String[] args) {
		Outer outer = new Outer();
		// 내부클래스 객체 생성
		Outer.InstanceInner instanceInner = outer.new InstanceInner();
		System.out.println("instanceInner.iv:" + instanceInner.iv);
		System.out.println();

		System.out.println("Outer.StaticInner.cv:" + Outer.StaticInner.cv);
		Outer.StaticInner.cv = 50;
		System.out.println("Outer.StaticInner.cv:" + Outer.StaticInner.cv);

		Outer.StaticInner staticInner = new Outer.StaticInner();
		System.out.println("staticInner.iv:" + staticInner.iv);
		System.out.println("staticInner.iv:" + staticInner.cv);
		System.out.println();

		outer.myMethod();
		instanceInner.myMethod();
		staticInner.myMethod();

		staticInner.iv = 50;
		System.out.println("staticInner.iv" + staticInner.iv);

	}

}
