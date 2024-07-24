package javalangex;

public class LangEx01 {

	public static void main(String[] args) {
		char a[] = { 'b', ' ', 'A', '5', '한' };
		//char a = new char[] {'b', ' ', 'A', '5', '한' };
		for (int i = 0; i < a.length; i++) {

			System.out.println("a[" + i + "] 요소 = " + a[i]);
			if (Character.isDigit(a[i]))
				System.out.println(" : 숫자");
			if (Character.isLetter(a[i]))
				System.out.println(" : 문자");

			if (Character.isWhitespace(a[i]))
				System.out.println(" : 공백문자");
			if (Character.isUpperCase(a[i]))
				System.out.println(" : 대문자");
			if (Character.isLowerCase(a[i]))
				System.out.println(" : 소문자");

		}
		
	}

}
