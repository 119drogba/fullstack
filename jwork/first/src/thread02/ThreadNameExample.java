package thread02;

public class ThreadNameExample {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread(); //현재 작업중 스레드들 가져와(메인스레드가져와)
		System.out.println("프로그램 시작 스레드 이름: " + mainThread.getName());//스레드 이름 가져와

		ThreadA threadA = new ThreadA();
		System.out.println("작업 스레드 이름: " + threadA.getName());
		threadA.start();

		ThreadB threadB = new ThreadB();
		System.out.println("작업 스레드 이름: " + threadB.getName());
		threadB.start();
	}

}
