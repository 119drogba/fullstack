package second;

public class FruitsEx {
	public static void main(String[] args) {

		int total; // 지역 변수 선언 (접근제어자x final만)

		Fruits f1 = new Fruits(30, 30, 30); // 생성자의 목적은 멤버필드 초기화
		// Fruits f2 = new Fruits ();
		total = f1.getSum(); // 메소드 호출문

		System.out.println("객체 f1의 총 개수 = " + total);
		System.out.println("객체 f1의 apple 개수 = " + f1.getApple());
		System.out.println("객체 f1의 straw 개수 = " + f1.getStraw());
		System.out.println("객체 f1의 grapes 개수 = " + f1.getGrapes());

	}

}
