//패키지: 나의 클래스의 소속을 명시
//형식: package 패키지경로만;
package second;

//패키지가 다른 클래스로 객체를 생성하는 경우는
//해당 클래스의 소속을 명시해 주어야 한다.
//명시하는 형식: import 패키지경로포함.클래스명까지;

import first.*;   //* 모두다(all)


public class Ex {
	public static void main(String[] args) {
		System.out.println("second패키지 안의 Ex클래스 입니다.");
		E e = new E();
	}
}
