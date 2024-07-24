package miniVO;

public class Student_scoreVO {
	private String s_num;
	private String e_id;
	private int s_score;
	public Student_scoreVO(String s_num, String e_id, int s_score) {
		this.s_num = s_num;
		this.e_id = e_id;
		this.s_score = s_score;
	}
	@Override
	public String toString() {
		return "Student_scoreVO [s_num=" + s_num + ", e_id=" + e_id + ", s_score=" + s_score + "]";
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
	public int getS_score() {
		return s_score;
	}
	public void setS_score(int s_score) {
		this.s_score = s_score;
	}
}
