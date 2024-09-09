package dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;
import vo.MemberVO;

public class MemberDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private DataSource ds;

    //DataSource 초기화
    public MemberDAO() {
        try {
        	Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			ds = (DataSource)envCtx.lookup("jdbc/OracleDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public boolean idCheck(MemberVO mv) {
        if(mv.getId() == null || mv.getId().length() == 0) {
        	System.out.println("아이디가 없습니다.");
        }
        boolean idchk = false;
        String SQL = "select count(*) as result from users where id = ? ";

        try {
        	con = ds.getConnection();
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, mv.getId());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
//	            int result = rs.getInt(1);
	            int result = rs.getInt("RESULT");
	            if(result > 0) idchk = true;
            }
            return idchk;
        } catch (SQLException e) { e.printStackTrace();}
        return idchk;
    }
}



