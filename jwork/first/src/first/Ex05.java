package first;

public class Ex05 {

	public static void main(String args[]) {

		System.out.println(area(5, 9, "try"));

		System.out.println(area(5, 3.14, "cir"));

	}

	public static double area(int i, double j, String s) {
		double area = 0;

		switch (s) { 
		case "try":
			area = i * j / 2;
			break;
		default:
			area = i * i * j;

		}
		return area;
	}
}
