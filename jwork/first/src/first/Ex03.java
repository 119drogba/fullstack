package first;

public class Ex03 {

	public static int abs(int a) {

		if (a < 0) {
			a = -a;

		}
		return a;
	}

	public static void main(String[] args) {
        System.out.println(abs(5));  
        System.out.println(abs(-5)); 
	}
}
