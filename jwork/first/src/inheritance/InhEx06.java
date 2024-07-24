package inheritance;

public class InhEx06 {

	public static void main(String[] args) {

		C2.x = "static제어자의 상속";

		C2.y = 20000;
		C1.x = 30000;
		System.out.println("C2.x:" + C2.x);
		System.out.println("C2.y:" + C2.y);
		System.out.println("C1.x:" + C1.x);

		C1 c1 = new C1();
		C1 c2 = new C2();
		c1.setY(6);
		System.out.println("c1.y:" + c1.y);
		System.out.println("c2.y:" + c2.y);

		c2.setY(100);
		System.out.println("c1.y:" + c1.y);
		System.out.println("c2.y:" + c2.y);

		c2.setC(90);
		System.out.println("c2.c:" + c2.c);

	}

}

class C1 {
	static int x;
	static int y;
	static int c;

	static void setX(int new_x) {
		System.out.println("C1의 setX메소드 실행");
		C1.x = new_x;
		// this.x = x;

	}

	static void setY(int new_y) {
		System.out.println("C1의 setY메소드 실행");
		C1.y = new_y;

	}

	static void setC(int new_c) {
		System.out.println("C1의 setC메소드 실행");
		C1.c = new_c;

	}
}

class C2 extends C1 {
	static String x;
	static int y;

	static void setX(String new_x) {
		System.out.println("C2의 setX메소드 실행");
		C2.x = new_x;
		// this.x = x;
		// super.setX(1);
	}

	static void setY(int new_y) {
		System.out.println("C2의 setY메소드 실행");
		C2.y = new_y;
	}
}
