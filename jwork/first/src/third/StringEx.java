package third;

public class StringEx {
	public static void main(String[] args) {
		
	//	char[] cArr = new char[5];  //문자배열
	//	String sAr = "12345";        //문자열
		
		//문자열 길이 : length()메소드
		
		String s = null;
		int str_l = s.length();
		System.out.println(s.length());
		
		String str = "안녕하세요, 반갑습니다.";
		int str_length = str.length();
		System.out.println("\""+str+"\"의 문자열 갯수(문자 길이)는" + str_length+"입니다.");
	}

}
