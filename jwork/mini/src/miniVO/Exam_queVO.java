package miniVO;

public class Exam_queVO {
	private String e_id;
	private int e_num;
	private String e_que;
	private int e_answer;
	public Exam_queVO(String e_id, int e_num, String e_que, int e_answer) {
		this.e_id = e_id;
		this.e_num = e_num;
		this.e_que = e_que;
		this.e_answer = e_answer;
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
	public String getE_que() {
		return e_que;
	}
	public void setE_que(String e_que) {
		this.e_que = e_que;
	}
	public int getE_answer() {
		return e_answer;
	}
	public void setE_answer(int e_answer) {
		this.e_answer = e_answer;
	}
	@Override
	public String toString() {
		return "Exam_queVO [e_id=" + e_id + ", e_num=" + e_num + ", e_que=" + e_que + ", e_answer=" + e_answer + "]";
	}
	
}
