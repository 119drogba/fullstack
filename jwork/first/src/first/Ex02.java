package first;

public class Ex02 {
	
	//매개변수 (Parameter Variable : 메소드 호출
	// 문에서 보내눈 값 (매개인자 = Argument Value)을 받아서 담아놓는
    // 역할을 하는 변수임.
                          
	public static void sum(int a, int b) {
		int c = a+b;                          
		System.out.println("a+b=" +c);
		
	}                
	
	public static void main(String[] args) { 
		int x = 10, y = 20;
		sum(4, 50);
		sum(x, y);
	}
}
