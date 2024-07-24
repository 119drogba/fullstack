package thread02;

public class ThreadB extends Thread {  
	public void run() {  //Thread1
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
			System.out.println(getName() + "가 출력한 내용");
			System.out.println(getName() + "가 출력한 내용");
			System.out.println(getName() + "가 출력한 내용");
			System.out.println(getName() + "가 출력한 내용");
		}
	}
}
