package innerex;

public class InnerEX02 {

	private int data = 30;

	void display() {
		class Local { // 지역 이너클래스
			public int b = 5;

			void msg() {
				System.out.println(data);
				display2();
			} // msg()종료 중괄호
		} // Local 클래스 종료 중괄호

		Local l = new Local();
		l.msg();
		System.out.println(l.b);
	} // display()메소드 종료 중괄호

	class InstanceInner {

		int iv = 100;

		void myMethod() {
			display();
//			msg();
			System.out.println("InstanceInner 클래스의 메소드 data : " + data + ",iv: " + iv);
		}
	}

	void display2() {
		System.out.println("display2() 메소드 호출");
	}

	public static void main(String[] args) {
		InnerEX02 obj = new InnerEX02();
		obj.display();
		InnerEX02.InstanceInner obj1 = obj.new InstanceInner();
		obj1.myMethod();

	}

}