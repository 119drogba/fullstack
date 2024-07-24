package innerex;

public class AnnonyEx02Test {
	public static void md(AnnonyEx02Abstract n) {
		n.doSomething();
	}

	public static void main(String[] args) {

		AnnonyEx02Test a = new AnnonyEx02Test();
		int aa = 5;
		final int AA = 7;

		a.md(new AnnonyEx02Abstract() {
			private int a = 15;
			String s = "AnnonymousClass";
			static final int AA = 0;
			// static int st =0;

			public void doSomething() {
				// aa= a+aa;  //한번도 값 변경이 안된 변수
				System.out.println("내부 익명 클래스의 doSomething메소드");

				System.out.println("s : " + s);
				System.out.println("a : " + a);
				System.out.println("aa : " + aa);
				System.out.println("AA : " + AA);
			} //익명 클래스로 자식에 객체 생성 ( 파차케이스)

		});

	}

}

abstract class AnnonyEx02Abstract {
	public abstract void doSomething();
}