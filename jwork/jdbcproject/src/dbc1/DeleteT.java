package dbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteT {

	public static void main(String[] args) {
		try {
			//오라클 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			
		
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "test";
			String pw = "1111";
			Connection conn = DriverManager.getConnection(url,user,pw);
			
			
			//Statement 객체 생성(명령문담고 실행할 수 있는 객체 생성)
			Statement st = conn.createStatement();
			
			int rowCount = st.executeQuery("delete from emp where empno="+empno);
			if(rowCount>0) 

	}

}
