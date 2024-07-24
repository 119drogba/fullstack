package second;

//고정형
public class Ex02 {
	public static void main(String[] args) {
		String s = new String("빨간불");
		String s1 = "빨간불";

		if (s.equals(s1)) {                    //객체의 값비교는 equals 사용
			System.out.println("빨간불입니다.");
		} else {
			System.out.println("빨간불이 아닙니다.");
		}
	}

	// String s = new String("안녕");
	// String s1 = "안녕";
	// String s2 = "안녕";

	// System.out.println("second 패키지 안의 Ex02클래스로 객체 생성");
	// MyDate md =new MyDate(31,5,2024);
	// MyDate md1 =new MyDate(31,5,2024);
}
// 같은 패키지인 경우 동일한 이름의 클래스(=자료형)를 만들 수 없다.
