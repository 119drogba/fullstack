package second;

public class ThisEx {

	public static void main(String[] args) {
		This a = new This();
		a.amd();
		a.setNum(2, "테스트");
		a.amd();

		int x = a.getNum();
		System.out.println(x);
		int y = a.getNum(5);
		System.out.println(y);
	}

}
