package first;

public class TestM {
	String[] sub = {"국어", "영어","수학"};
	int [] score = {80, 90, 95};
	int total = 0;
	//public TestM(){}
	//총점을 반환하는 메소드
	public int getTotal() {
		
		for(int i=0; i<score.length; i++) {
		total += score[i];
		
	}
		return total;

}
	//평균을 반환하는 메소드
	public double getAVG() {
		return (double) getTotal()/sub.length;
	}

	//과목별 점수를 출력하는 방법
	public void result() {
		for(int i=0; i<sub.length; i++) {
			System.out.printf("%s 점수: %d %n ",sub[i],score[i]);
			
		}
	}}