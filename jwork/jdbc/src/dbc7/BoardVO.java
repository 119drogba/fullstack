package dbc7;

public class BoardVO {

	private int id; //0
	private String writer; //홍길동
	private String passwd; //1111
	private String subject; //테스트입니다
	private String email; 

	
	
	public BoardVO(int id, String writer, String passwd, String subject, String email) {
		this.id = id;
		this.writer = writer;
		this.passwd = passwd;
		this.subject = subject;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BoardVO [아이디=" + id + ", 쓰는놈=" + writer + ", 비밀번호=" + passwd + ", subject=" + subject + ", email="
				+ email + "]";
	}

}
