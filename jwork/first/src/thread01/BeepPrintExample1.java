package thread01;

public class BeepPrintExample1 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("동");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}

}
