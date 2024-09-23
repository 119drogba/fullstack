package DAO;

import VO.ProfessorVO;
import java.sql.*;

public class ProfessorDAO {
    private static ProfessorDAO instance;
    private Connection con;

    private ProfessorDAO() {}

    public static ProfessorDAO getInstance() {
        if (instance == null) {
            instance = new ProfessorDAO();
        }
        return instance;
    }

    public void setConnection(Connection con) {
        this.con = con;
    }

    // 교수 로그인 인증 메서드
    public ProfessorVO authenticate(String id, String password) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ProfessorVO professor = null;

        try {
            // 데이터베이스 테이블과 컬럼 이름에 맞게 수정하세요.
            String sql = "SELECT * FROM professors WHERE professor_id = ? AND professor_pw = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                professor = new ProfessorVO();
                professor.setProfessor_id(rs.getString("professor_id"));
                professor.setProfessor_pw(rs.getString("professor_pw"));
                professor.setProfessor_name(rs.getString("professor_name"));
                professor.setProfessor_email(rs.getString("professor_email"));
                professor.setProfessor_ph(rs.getInt("professor_ph"));
                professor.setProfessor_status(rs.getString("professor_status"));
                // 기타 필요한 필드 설정
            }
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception ignore) {}
            if (pstmt != null) try { pstmt.close(); } catch (Exception ignore) {}
        }

        return professor;
    }
}
