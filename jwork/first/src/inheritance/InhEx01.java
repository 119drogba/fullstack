package inheritance;

//java.lang 패키지 소속일때 import 생략 

public class InhEx01 {
	
	public static void main(String [] args) {
		
		//Object클래스 상속을 통한 메소드 재정의
		Class c1 = String.class;   //앞에 있는 클래스의 정보를 가져오세요
		System.out.println(c1);
		System.out.println(c1.getClass());
		//c1= "하하핳";
		String str1 = new String();
		System.out.println(str1.getClass());
		Class c2 = str1.getClass();
		System.out.println(c2);

	
	}

}
