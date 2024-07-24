package third;

public class Box {

	long idNum;
	static long boxID=0;
	
	public Box() {
		idNum = boxID++;
		
		
	}
	@Override
	public String toString() {
		return "Box클래스로 만든 인스턴스를 받은 인스턴스 객체입니다.";
	}
	
}
