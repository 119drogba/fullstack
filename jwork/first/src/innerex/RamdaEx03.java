package innerex;

interface Ramda3 {
	public abstract void add(int a, int b);
}
//abstract class Ramda3 {
//public abstract void add(int a , int b)
//}

public class RamdaEx03 {

	public static void main(String[] args) {

		int i = 100;
		// static final int j =5;
		final int j = 5;

		// 수행문이 여러 줄 인 경우 {} 중괄호 블록을 사용한다.
		Ramda3 result = (p1, p2) -> { //메소드단에는 final 제어자만 사용가능!!
//			i = i + p1 + p2; //익명클래스와 마찬가지로 Effectively final만 가능하다.
			int sum = p1 + p2;
			final int mul = p1 * p2;
//			static final int mul = p1*p2;
			System.out.println("i는: " + i + ",j는: " + j);
			System.out.println(p1 + "," + p2);
			System.out.println("p1과 p2의 합: " + sum);
			System.out.println("p1과 p2의 곱: " + mul);
		};
		result.add(5, 5);

	}

}
