package miniVO;

public class Student_answersVO {
	private String s_num;
	private String  e_id;
	private int e_num;
	private int s_answer;
	public Student_answersVO(String s_num, String e_id, int e_num, int s_answer) {
		this.s_num = s_num;
		this.e_id = e_id;
		this.e_num = e_num;
		this.s_answer = s_answer;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public int getE_num() {
		return e_num;
	}
	public void setE_num(int e_num) {
		this.e_num = e_num;
	}
	public int getS_answer() {
		return s_answer;
	}
	public void setS_answer(int s_answer) {
		this.s_answer = s_answer;
	}
	@Override
	public String toString() {
		return "Student_answersVO [s_num=" + s_num + ", e_id=" + e_id + ", e_num=" + e_num + ", s_answer=" + s_answer
				+ "]";
	}
	
}
