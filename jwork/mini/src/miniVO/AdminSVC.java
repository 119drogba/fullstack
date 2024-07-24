package miniVO;

import static mini.Connect.*;

import java.sql.*;
import java.util.*;

public class AdminSVC {
	   Connection con;

	   public void insertStudent(AdminVO ad_user) {// 학생등록
	      con = getConnection();
	      PreparedStatement pstmt = null;
	      int count = 0;
	      try {
	         getAdmin(ad_user).getA_state();

	         if (getAdmin(ad_user).getA_state().equals("Y")) {
	            Scanner sc = new Scanner(System.in);
	            String sql = "insert into Student (S_NUM,S_NAME,s_hire) values(?,?,?)";
	            System.out.println("학생 등록메뉴");
	            System.out.print("학번입력 (예:20240001) >>");
	            String s_num = sc.next();

	            System.out.print("이름입력>>");
	            String s_id = sc.next();

	            System.out.print("입학일자>> ");
	            String s_hire = sc.next();

	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, s_num);
	            pstmt.setString(2, s_id);
	            pstmt.setString(3, s_hire);
	            count = pstmt.executeUpdate();
	            if (count > 0)
	               System.out.println("등록 성공");
	            else
	               System.out.println("등록 실패");
	            
	         } else {
	            System.out.println("관리자 권한이 없습니다.");

	         }
	      } catch (Exception e) {

	      } finally {
	         try {
	            if (con != null)
	               con.close();
	            if (pstmt != null)
	               pstmt.close();

	         } catch (Exception e) {
	            // TODO: handle exception
	         }
	      }

	   }

	   public void updateAdmin(AdminVO Ad_user) {
	      con = getConnection();
	      PreparedStatement pstmt = null;
	      int count = 0;

	      try {

	         System.out.println("관리자 사용상태변경");
	         System.out.print("변경할 상태변경할 관리자아이디\n>>");
	         Scanner sc = new Scanner(System.in);
	         String a_id = sc.next();

	         AdminVO adminVO = getAdmin(a_id);
	         if (adminVO == null) {
	            System.out.println("존재하지 않는 관리자 입니다.  관리자메뉴로돌아갑니다.");

	         } else {

	            System.out.println("현재 상태 : " + adminVO.getA_state());
	            System.out.print("변경할 상태 입력(1.사용가능(Y) ,2.사용불가(N) 3.관리자메뉴 로 돌아가기)\n>>");

	            String num = sc.next();
	            getAdmin(Ad_user).getA_roll();
	            if (Ad_user.getA_roll().equals("SUPER")) {
	               String sql = "update admin set a_state ='Y' where a_id=?";
	               Roll: while (true) {

	                  switch (num) {
	                  case "1":
	                     pstmt = con.prepareStatement(sql);
	                     pstmt.setString(1, a_id);
	                     count = pstmt.executeUpdate();

	                     if (count > 0) {
	                        System.out.println("변경 완료 되었습니다.");

	                        break Roll;
	                     } else {
	                        System.out.println("변경에 실패했습니다. 관리자 메뉴로 돌아갑니다.");

	                        break Roll;
	                     }

	                  case "2":
	                     pstmt = con.prepareStatement("update admin set a_state ='N' where a_id=?");
	                     pstmt.setString(1, a_id);
	                     count = pstmt.executeUpdate();
	                     if (count > 0) {
	                        System.out.println("변경 완료 되었습니다.");

	                        break Roll;
	                     } else {
	                        System.out.println("변경에 실패했습니다. 관리자 메뉴로 돌아갑니다.");

	                        break Roll;
	                     }
	                  case "3":
	                     System.out.println("관리자 메뉴로 돌아갑니다.");

	                     break Roll;
	                  default:
	                     System.out.print("잘못된 입력입니다 다시입력해주세요.(1.사용가능(Y) ,2.사용불가(N) 3.관리자메뉴 로 돌아가기)\n>>");
	                     break;
	                  }
	                  num = sc.next();
	               }
	            } else {
	               System.out.println("SUPER 권한이 필요합니다.");
	            }
	         }
	      } catch (Exception e) {
	         System.out.println("오류발생");
	      } finally {
	         try {
	            if (con != null)
	               con.close();
	            if (pstmt != null)
	               pstmt.close();
	         } catch (Exception e2) {
	            // TODO: handle exception
	         }
	      }
	   }

	   public void updatea_rolls(AdminVO Ad_user) { // 역활변경
	      System.out.println("역활 변경 메뉴");
	      getAdmin(Ad_user).getA_roll();
	      System.out.print("변경할 아이디입력 \n>>");
	      Scanner sc = new Scanner(System.in);
	      String a_id = sc.next();
	      AdminVO adminVO = getAdmin(a_id);
	      if (adminVO == null) {
	         System.out.println("관리자 아이디가존재 하지않습니다. 관리자메뉴로돌아갑니다.");

	      } else {

	         System.out.println("부여된 역활 : " + adminVO.getA_roll());
	         System.out.println("변경할 역활 입력(1,SUPER 2,SUB) >>");
	         String num = sc.next();
	         STATE: while (true) {
	            switch (num) {
	            case "1":
	               if (Ad_user.getA_roll().equals("SUPER")) {
	                  updatea_roll(a_id);

	                  if (updatea_roll(a_id) > 0) {
	                     System.out.println("변경이 완료되었습니다.");
	                     break STATE;
	                  }
	               } else {
	                  System.out.println("SUPER 권한이 필요합니다.");
	                  break STATE;
	               }
	               break;
	            case "2":
	               if (Ad_user.getA_roll().equals("SUPER")) {
	                  updatea_rollSUB(a_id);

	                  if (updatea_rollSUB(a_id) > 0) {
	                     System.out.println("변경이 완료되었습니다.");
	                  }
	                  break STATE;
	               } else {
	                  System.out.println("SUPER 권한이 필요합니다.");
	                  break STATE;
	               }
	            default:
	               System.out.print("잘못된 입력입니다 다시 입력해주세요(1,SUPER 2,SUB)\n>>");
	               break;
	            }
	            num = sc.next();
	         }
	      }
	   }

	   public int updatea_roll(String a_id) {
	      int updateCount = 0;
	      con = getConnection();
	      getAdmin(a_id).getA_roll();
	      PreparedStatement pstmt = null;

	      String sql = "update admin set a_roll='SUPER' where a_id=?";

	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, a_id);

	         updateCount = pstmt.executeUpdate();

	      } catch (Exception e) {
	         System.out.println("updatea_roll 오류발생");

	      } finally {
	         try {

	            if (pstmt != null)
	               pstmt.close();
	            if (con != null)
	               con.close();

	         } catch (Exception e) {
	            System.out.println("updatea_roll  finally오류발생");
	         }
	      }

	      return updateCount;
	   }

	   public int updatea_rollSUB(String a_id) {
	      int updateCount = 0;
	      con = getConnection();
	      PreparedStatement pstmt = null;
	      getAdmin(a_id);

	      String sql = "update admin set a_roll='SUB' where a_id= ?";

	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, a_id);

	         updateCount = pstmt.executeUpdate();

	      } catch (Exception e) {
	         System.out.println("updatea_rollSUB 오류발생");

	      }finally {
	         try {

	            if (pstmt != null)
	               pstmt.close();
	            if (con != null)
	               con.close();

	         } catch (Exception e) {
	            System.out.println("updatea_rollSUB  finally오류발생");
	         }
	      }
	      return updateCount;

	   }

	   public AdminVO getAdmin(AdminVO Ad_user) {
	      AdminVO adminVO = null;
	      con = getConnection();
	      String a_id = Ad_user.getA_id();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "select * from admin where a_id =?";
	      try {
	         pstmt = con.prepareStatement(sql);

	         pstmt.setString(1, a_id);
	         rs = pstmt.executeQuery();

	         if (rs.next()) {
	            String dbid = rs.getString("a_id");
	            String a_pwd = rs.getString("a_pwd");
	            String a_name = rs.getString("a_name");
	            String a_roll = rs.getString("a_roll");
	            String a_state = rs.getString("a_state");

	            adminVO = new AdminVO(dbid, a_pwd, a_name, a_roll, a_state);

	         }
	      } catch (Exception e) {
	         System.out.println("getAdmin(AdminVO Ad_user)오류발생");
	      } finally {
	         try {

	            if (pstmt != null)
	               pstmt.close();
	            if (rs != null)
	               rs.close();
	         } catch (Exception e) {
	            System.out.println("getAdmin(AdminVO Ad_user) finally 오류발생");

	         }
	      }
	      return adminVO;

	   }

	   public AdminVO getAdmin(String a_id) {
	      AdminVO adminVO = null;
	      con = getConnection();

	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "select * from admin where a_id =?";
	      try {
	         pstmt = con.prepareStatement(sql);

	         pstmt.setString(1, a_id);
	         rs = pstmt.executeQuery();

	         if (rs.next()) {
	            String dbid = rs.getString("a_id");
	            String a_pwd = rs.getString("a_pwd");
	            String a_name = rs.getString("a_name");
	            String a_roll = rs.getString("a_roll");
	            String a_state = rs.getString("a_state");

	            adminVO = new AdminVO(dbid, a_pwd, a_name, a_roll, a_state);

	         }
	      } catch (Exception e) {
	         System.out.println("getAdmin(String a_id) 오류발생");
	      } finally {
	         try {

	            if (pstmt != null)
	               pstmt.close();
	            if (rs != null)
	               rs.close();
	         } catch (Exception e) {
	            System.out.println("getAdmin(String a_id) finally 오류발생");
	         }
	      }
	      return adminVO;

	   }

	}