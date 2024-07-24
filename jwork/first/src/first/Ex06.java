package first;

public class Ex06 {
	public static void printstr(String str) {
		System.out.println(str);
	}
	public static void printstr(char ch, int cnt ) {
		for(int i =0; i<cnt;  i++)
			System.out.print(ch);
		System.out.println();
	}
	
	
	public static void main(String [] args ) {
		printstr("즐거운 점심시간입니다.");
		printstr('A', 10);
		
	}

}
