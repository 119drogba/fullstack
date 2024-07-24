package innerex;

interface Ramda5 {
	void showString(String str);
}

public class RamdaEx05 {

	public static void main(String[] args) {
		Ramda5 lamda5 = returnString(); // 주소값으로 반환 받기
		lamda5.showString("hello");

	}

	public static Ramda5 returnString() {
		return s -> System.out.println(s + " Java");

//		new lamda5 () {
//			void showString(String s);
//			System.out.println(s + "Java");

	}
}
