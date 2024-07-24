package miniVO;

public class StudentVO {
	private String s_num;
	private String s_name;
	private String s_id;
	private String s_pwd;
	private String s_hire;
	private String s_state;
	
	public StudentVO(String s_num, String s_name, String s_id, String s_pwd, String s_hire, String s_state) {
		this.s_num = s_num;
		this.s_name = s_name;
		this.s_id = s_id;
		this.s_pwd = s_pwd;
		this.s_hire = s_hire;
		this.s_state = s_state;
	}
	
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_pwd() {
		return s_pwd;
	}
	public void setS_pwd(String s_pwd) {
		this.s_pwd = s_pwd;
	}
	public String getS_hire() {
		return s_hire;
	}
	public void setS_hire(String s_hire) {
		this.s_hire = s_hire;
	}
	public String getS_state() {
		return s_state;
	}
	public void setS_state(String s_state) {
		this.s_state = s_state;
	}
	
	@Override
	public String toString() {
		return "StudentVO [s_num=" + s_num + ", s_name=" + s_name + ", s_id=" + s_id + ", s_pwd=" + s_pwd + ", s_hire="
				+ s_hire + ", s_state=" + s_state + "]";
	}
	
	
}
