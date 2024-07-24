package miniVO;

public class AdminVO {
	private String a_id;
	private String a_pwd;
	private String a_name;
	private String a_roll;
	private String a_state;
	
	public AdminVO(String a_id, String a_pwd, String a_name, String a_roll, String a_state) {
		this.a_id = a_id;
		this.a_pwd = a_pwd;
		this.a_name = a_name;
		this.a_roll = a_roll;
		this.a_state = a_state;
	}
	
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_pwd() {
		return a_pwd;
	}
	public void setA_pwd(String a_pwd) {
		this.a_pwd = a_pwd;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_roll() {
		return a_roll;
	}
	public void setA_roll(String a_roll) {
		this.a_roll = a_roll;
	}
	public String getA_state() {
		return a_state;
	}
	public void setA_state(String a_state) {
		this.a_state = a_state;
	}

	@Override
	public String toString() {
		return "AdminVO [a_id=" + a_id + ", a_pwd=" + a_pwd + ", a_name=" + a_name + ", a_roll=" + a_roll + ", a_state="
				+ a_state + "]";
	}
	
}
