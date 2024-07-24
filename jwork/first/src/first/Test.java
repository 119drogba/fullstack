package first;



public class Test {

	public static void main(String[] args) {
		TestM tm = new TestM(); // 자료형() => 기본생성자 호출문
		System.out.println("총점은 :" +tm.getTotal());
		System.out.printf("평균은:%.2f \n", tm.getAVG());
		tm.result();
		
		
	}

}
