package exceptex;

public class ExceptEx08 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");

		try {
			System.out.println("try문 시작");
			findClass(); // 동일한 클래스안에 들어가있고 static
			System.out.println("try문 종료");
		} catch (Exception e) {
			System.out.println("클래스가 존재하지 않습니다.");
			System.out.println("에러 사유: " + e);
		}
		System.out.println("프로그램 종료");
	}

	public static void findClass() throws ClassNotFoundException {
		System.out.println("findClass메소드 실행");
		Class clazz = Class.forName("java.lang.WowClass");
	}
}

//보내는곳보다 받는곳이 더 커야한다 **
// try catch문이 가장 우선 순위