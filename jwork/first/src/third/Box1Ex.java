package third;

public class Box1Ex {

	public static void main(String[] args) {
		
		Box1 mybox1 = new Box1();
		mybox1.idNum = Box1.getcurrentID();
		
		Box1 mybox2 = new Box1();
		mybox2.idNum = mybox2.getcurrentID();
		
		System.out.println("mybox1의 id 번호 :" + mybox1.idNum);
		System.out.println("mybox2의 id 번호 :" + mybox2.idNum);
		System.out.println("다음 박스의 번호는" + Box1.boxID+"번 입니다.");
		
		
		
	}

}
