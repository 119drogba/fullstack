package thread01;

public class BeepTask implements Runnable {

	public void run() { //Thread0
		for (int i = 0; i < 5; i++) {
			System.out.println("동");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}
}
