package miniVO;

public class ExamsVO {
	private String e_id;
	private String e_year;
	private String e_term;
	private String e_subject;
	
	public ExamsVO(String e_id, String e_year, String e_term, String e_subject) {
		this.e_id = e_id;
		this.e_year = e_year;
		this.e_term = e_term;
		this.e_subject = e_subject;
	}
	
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getE_year() {
		return e_year;
	}
	public void setE_year(String e_year) {
		this.e_year = e_year;
	}
	public String getE_term() {
		return e_term;
	}
	public void setE_term(String e_term) {
		this.e_term = e_term;
	}
	public String getE_subject() {
		return e_subject;
	}
	public void setE_subject(String e_subject) {
		this.e_subject = e_subject;
	}
	
	@Override
	public String toString() {
		return "ExamsVO [e_id=" + e_id + ", e_year=" + e_year + ", e_term=" + e_term + ", e_subject=" + e_subject + "]";
	}
	
	
	
}
