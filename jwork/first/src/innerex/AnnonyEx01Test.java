package innerex;

public class AnnonyEx01Test {

	public static void main(String[] args) {
		int aa = 5;
		final int AA = 7; // 상수는 한번 값을 대입하면 끝

		AnnonyEx01Abstract myClass = new ASub() {
			private int a = 15;
			String s = "AnnonymousClass";
			final int AA = 0;
			// static final int AA =0;
			// static int st = 0;
			//익명 클래스안에 static 붙을수 있는건 상수 (final)
			//익명 클래스에서 오버라이드된 메소드만 접근 가능
			public void doSomething() {
				// aa=a + aa;
				super.doSomething();
				System.out.println("내부 익명 클래스의 doSomething메소드");

				System.out.println("s : " + s);
				System.out.println("a : " + a);
				System.out.println("aa : " + aa);
				System.out.println("AA : " + AA);

				etcMethod();
			}

			public void etcMethod() {
				System.out.println("기본 메소드입니다.");
			}
		};
		myClass.doSomething();
		// myClass.etcMethod();
		// aa = aa+15;

		System.out.println("aa: " + aa);
		// System.out.println(myClass.s);

	}
}

abstract class AnnonyEx01Abstract {
	public String s; //null 

	public abstract void doSomething();
}

class ASub extends AnnonyEx01Abstract {
	public void doSomething() {
		System.out.println("ASub클래스 doSomething()메소드 호출");
	}
}
