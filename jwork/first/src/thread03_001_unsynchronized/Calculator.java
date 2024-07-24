package thread03_001_unsynchronized;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000); // 실행하고 있는 스레드가 주체
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}

}
