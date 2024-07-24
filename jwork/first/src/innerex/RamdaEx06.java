package innerex;

interface Ramda6 {
	public abstract void add(int a, int b);
}


public class RamdaEx06 {

	public static void main(String[] args) {

		

		
		Ramda6 result = (p1, p2) -> { 

			int sum = p1 + p2;
			int mul = p1 * p2;
			int sin = p1 - p2;
			int son = p1 / p2;
			int san = p1 % p2;

			
			System.out.println(sum);
			System.out.println(mul);
			System.out.println(sin);
			System.out.println(son);
			System.out.println(san);
			
		};
		
		result.add(5, 5);
	}

}
