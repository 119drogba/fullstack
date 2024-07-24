package thread01;

public class BeepPrintExample2 {

	public static void main(String[] args) { // Main Thread
		
//		Runnable beepTask = new BeepTask();
//		Thread thread = new Thread(beepTask); //Thread0
//		thread.start();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("동");
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
			}
		});
		thread.start();
		// Runnable객체를 직접 생성하여 스레드생성자의 매개인자로 보내어 스레드 객체 생성
		Thread thread1 = new Thread(() -> {   //Thread1
			for (int i = 0; i < 5; i++) {
				System.out.println("댕");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
			}
		});
		thread1.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}

	}

}
