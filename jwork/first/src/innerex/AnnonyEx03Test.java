package innerex;
//접근제어자 생략 default 기타제어자 생략 없다
class AnnonyEx03 {
	void amd() {
		System.out.println("AnnonyEx03 클래스의 amd()메소드 호출");
	}
}

public class AnnonyEx03Test {

	public static void main(String[] args) {
		AnnonyEx03 ac3 = new AnnonyEx03() {
			//익명클래스
			int c = 5; //멤버변수 

			void cmd() {
				System.out.println("익명클래스의 cmd() 메소드");
			}
		};
		ac3.amd();
		// ac3.cmd();

	}

}
