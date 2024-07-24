package miniVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import mini.Connect;

public class ExamsSVC {
	Connection con= null;
	Statement st= null;
	PreparedStatement pst= null;
	ResultSet rs= null;
	ResultSet rs2= null;
	String sql= null;
	
	public void ExamsStart(String s_num) { //시험응시
		System.out.println("시험응시시작");
		con = Connect.getConnection();
		try {
			con.setAutoCommit(false);

			
			sql = "select * from exams where  e_year='2024' and e_term=1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			String e_id = null;
			
			while(rs.next()){ // 시험정보 불러오는 메소드
				e_id = rs.getString("e_id");
				String e_year = rs.getString("e_year");
				String e_term = rs.getString("e_term");
				String e_subject = rs.getString("e_subject");
				
				sql = "select * from STUDENT_ANSWERS where s_num = ? and e_id = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, s_num);
				pst.setString(2, e_id);
				
				rs2 = pst.executeQuery();
				if(rs2.next()) { // 응시한 시험이면 종료
					System.out.println(e_year+"년 "+e_term+"학기 " + e_subject +"시험은 응시하였습니다.");
					System.out.println();
					rs2.close(); rs.close(); pst.close(); st.close(); con.close();
					return;
				}
				
				rs2.close();
				
				System.out.println(e_year+"년 "+e_term+"학기 " + e_subject +"시험 시작");
			}
			
			sql = "select * from exam_que where e_id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, e_id);
			rs = pst.executeQuery();
	
			Scanner sc = new Scanner(System.in);
			
			while(rs.next()) { 
				System.out.println(rs.getString("E_QUE"));
				System.out.print("답안을 입력(번호로 입력해주세요): ");
				
				int s_answer = sc.nextInt();
				
				System.out.println();
				int e_num = rs.getInt("e_num");
				
				sql = "insert into STUDENT_ANSWERS values(?,?,?,?)";
				
				pst = con.prepareStatement(sql);
				pst.setString(1, s_num);
				pst.setString(2, e_id);
				pst.setInt(3, e_num);
				pst.setInt(4, s_answer);
				
				pst.executeUpdate();
			}
			
			while(true) { // 답안수정 반복
				System.out.println("선택 : 1.시험종료  2.답안수정");
				System.out.print(">>");
				int y_no = sc.nextInt();
				
				if(y_no == 1){
					System.out.println("시험응시가 완료 되었습니다."); 
					con.commit(); break;
				}else {
					System.out.print("수정할 문제 번호 입력>>");
					int re_e_num = sc.nextInt();
					sql = "select * from exam_que where e_id = ? and e_num =? ";
					
					pst = con.prepareStatement(sql);
					pst.setString(1, e_id);
					pst.setInt(2, re_e_num);
					rs = pst.executeQuery();
			
					while(rs.next()) { 
						System.out.println(rs.getString("E_QUE"));
						System.out.print("답안을 입력(번호로 입력해주세요): ");
						
						int s_answer = sc.nextInt();
						System.out.println();
						
						sql = "update STUDENT_ANSWERS set s_answer = ? "
								+ "where s_num = ? and e_id = ? and e_num = ?";
						
						pst = con.prepareStatement(sql);
						pst.setInt(1, s_answer);
						pst.setString(2, s_num);
						pst.setString(3, e_id);
						pst.setInt(4,re_e_num);
						
						pst.executeUpdate();
					}
				}
			}
			
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			try {
				if (rs != null) rs.close();
				if (st != null)st.close();
				if (pst != null) pst.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	public void Exams_Score(String s_num) { // 시험점수확인
		con = Connect.getConnection();
		
		System.out.println("확인하고 싶은 년도와 학기를 입력하세요.");
		System.out.print("년도입력(예: 2024) >>");
		
		Scanner sc = new Scanner(System.in);
		String e_year = sc.nextLine();
		
		System.out.println("학기 선택(숫자로입력): 1.1학기 2.2학기");
		System.out.print(">>");
		String e_term = sc.nextLine();
		
		
		try {
			sql = "select e_id from exams where e_year=? and e_term=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, e_year);
			pst.setString(2, e_term);
			
			rs = pst.executeQuery();
			String e_id = null;
			
			while(rs.next()) { //어떤 시험인지 불러오기
				e_id = rs.getString("e_id");
			}
			
			int total = Exams_Total(s_num , e_id);
			if(total == -1) {
				System.out.print(e_year+"년 "+e_term+"학기 ");
				System.out.println("시험을 응시하지 않았습니다.");
				System.out.println();
				rs.close(); pst.close(); con.close(); return;
			}
			
			
			System.out.println(e_year+"년 "+e_term+"학기 성적확인");
			System.out.println("=============================");
			System.out.println("총점: " + total);
			
			sql = "select s_num, s.e_num,e.e_answer ,s_answer,e_score "
					+ "from student_answers s , exam_que e "
					+ "where s_num = ? and s.e_id = ? and s.e_num = e.e_num";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, s_num);
			pst.setString(2, e_id);
			rs = pst.executeQuery();
			
			while(rs.next()) { 
				System.out.print(rs.getInt("e_num")+"번.: ");
				
				if(rs.getInt("e_answer") ==rs.getInt("s_answer") ) {
					System.out.println("O");
				}else System.out.println("X");
				
			}
			
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	public int Exams_Total(String s_num , String e_id) { //해당시험 학생에 총점구하기
		con = Connect.getConnection();
		
		int total = 0;
			
		try {
			sql = "select s_num, s.e_num,e.e_answer ,s_answer,e_score "
					+ "from student_answers s , exam_que e "
					+ "where s_num = ? and s.e_id = ? and s.e_num = e.e_num";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, s_num);
			pst.setString(2, e_id);
			rs = pst.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				total = -1;
			}
			
			
			while(rs.next()) { //어떤 시험인지 불러오기	
				if(rs.getInt("e_answer") ==rs.getInt("s_answer") ) {
					total += rs.getInt("e_score");
					
				}	
			}
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return total;
	}
	
}
