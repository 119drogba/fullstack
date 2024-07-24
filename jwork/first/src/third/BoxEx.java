package third;

public class BoxEx {
	public static void main(String[] args) {
		
		Box box1 = new Box(); //객체 생성문
		Box box2 = new Box();
		Box box3 = new Box();
		Box box4 = new Box();

		System.out.println("box1의 idNum : " + box1.idNum);
		System.out.println("box2의 idNum : " + box2.idNum);
		System.out.println("box3의 idNum : " + box3.idNum);
		System.out.println("box4의 idNum : " + box4.idNum);
		System.out.println("박스 총 개수 : " + Box.boxID);

		
	}
}
