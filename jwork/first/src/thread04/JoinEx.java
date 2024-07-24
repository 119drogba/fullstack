package thread04;

public class JoinEx {

	public static void main(String[] args) { // main 스레드
		MyThread thread = new MyThread();
		// Thread 시작
		thread.start(); // Thread-0
		System.out.println("Thread가 종료될때까지 기다립니다.");

		User1 us = new User1();
		us.mt = thread;
		us.start(); // Thread-1
		
		try {
			// 해당 쓰레드가 멈출때까지 멈춤
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread가 종료되었습니다.");
	}

}

class MyThread extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("MyThread5 :" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
