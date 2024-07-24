package thread01;

public class BeepPrintExample3 {

	public static void main(String[] args) {

		// Thread를 상속받은 하위클래스로 객체를 생성하면 Runnable객체를 구현하지 않아도 스레드 작업이 가능하다.
		Thread thread = new BeepThread();

		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}

	}

}
