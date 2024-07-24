package exceptex;

public class ExceptEx04 {

	public static void main(String[] args) {
		try {

//			해보기 :
//			매개인자 1개 입력하고 실행하기 : 숫자로
//			매개인자 2개 입력하고 실행하기 : 숫자로, 젯수 0으로 입력하기
//			매개인자 String로 입력하고 실행하기

			System.out.println("매개변수로 받은 두 개의 값");
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			System.out.println("a=" + a + "b=" + b);
			System.out.println("a를 b로 나눈 몫 = " + (a / b));
			System.out.println("나눗셈 수행");
		} catch (ArithmeticException e) {

			System.out.println("===============================");
			System.out.println("산술 연산 오류 처리 루틴 : ");
			System.out.println(e + "예외 발생");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("================================");
			System.out.println("배열 범위 오류 처리 처리 루틴");
			System.out.println(e + "예외 발생");

		} catch (NumberFormatException e) {
			System.out.println("==================================");
			System.out.println("숫자 형식 오류 처리 루틴");
			System.out.println(e + "예외 발생");
		} catch (Exception e) {
			System.out.println("가장 최상위 에러(모든에러) 처리 루틴");
		} finally {
			System.out.println("===================================");
			System.out.println("finally 블럭 수행");
		}

	}

}
