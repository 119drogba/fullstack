package mini;

import java.util.Scanner;

import miniVO.*;

public class LmsMain {

	   public static void main(String[] args) {
	      ExamsSVC examsSVC = new ExamsSVC(); //창욱
	      AdminSVC adminSVC = new AdminSVC(); //기홍
	      AdminLoginSVC adminloginSVC = new AdminLoginSVC(); //지수
	      Student_LoginSVC student_loginSVC = new Student_LoginSVC(); // 여완
	      
	      StudentVO st_user = null;
	      AdminVO ad_user = null;
	      Scanner sc = new Scanner(System.in);
	      
	      while(true) { 
	         System.out.println("메뉴선택: 1.관리자 2.학생 3.시스템종료");
	         System.out.print(">> ");
	         int menu = scanint(sc);
	         
	         switch (menu) { // 메인메뉴
	         case 1:
	            adminmenu: while (true) {//관리자메뉴
	               System.out.println("관리자 메뉴 시작");
	               System.out.println("메뉴선택: 1.관리자 로그인  2.관리자 가입  3.관리자 현황 4.홈으로");
	               System.out.print(">> ");
	               menu = scanint(sc);

	               switch (menu) {
	               case 1: //관리자 로그인
	                  ad_user = adminloginSVC.login(sc);
	            
	                  if (ad_user != null) {// 로그인 성공여부
	                     while(true) {   
	                        System.out.println("관리자메뉴 선택: 1.학생등록 2.상태변경 3.역할변경 4.로그아웃");
	                        System.out.print(">> ");
	                        menu = scanint(sc);
	                        
	                        switch (menu) {
	                        case 1:
	                           System.out.println("학생등록 메뉴");
	                           adminSVC.insertStudent(ad_user);
	                           break;
	                           
	                        case 2: //상태변경
	                           adminSVC.updateAdmin(ad_user);
	                           break;
	                           
	                        case 3: // 역할변경
	                           adminSVC.updatea_rolls(ad_user);
	                           
	                           break;
	                        case 4: // 로그아웃
	                           ad_user = null; break adminmenu;
	                        }
	                     }
	                  } 
	                  break;
	               case 2: // 관리자 가입
	                  adminloginSVC.insertMember(sc);
	                  break;
	               case 3: // 관리자 목록보기
	                  adminloginSVC.selectMember();
	               case 4:break adminmenu;
	               }
	            }
	            break;
	         case 2: //학생메뉴
	            studentmenu: while (true) {
	               System.out.println("학생 메뉴 시작");
	               System.out.println("메뉴선택: 1.로그인  2.회원가입 3.학생현황 4.홈으로");
	               System.out.print(">> ");
	               menu = scanint(sc);

	               switch (menu) {
	               case 1: //학생 로그인
	                  st_user = student_loginSVC.login(sc);
	                  if (st_user != null) {// 로그인 성공여부
	                     while(true) {   
	                        System.out.println("학생메뉴 선택: 1.시험응시 2.점수확인 3.로그아웃");
	                        System.out.print(">> ");
	                        menu = scanint(sc);
	                        
	                        switch (menu) {
	                        case 1: // 시험응시
	                           examsSVC.ExamsStart(st_user.getS_num());
	                           break;
	                           
	                        case 2: // 점수확인
	                           examsSVC.Exams_Score(st_user.getS_num());
	                           break;
	                           
	                        case 3:// 로그아웃
	                           st_user=null; break studentmenu;
	                        }
	                     }
	                  }
	                  break;
	               case 2: // 학생 회원가입
	                  student_loginSVC.updateStudent(sc);
	                  break;
	               case 3: //학생현황
	            	   student_loginSVC.studentmeber();
	               case 4://홈으로
	            	   break studentmenu;
	               }
	            }
	            break;
	         case 3:
	            System.out.println("시스템이 종료되었습니다."); 
	            sc.close();
	            return;

	         } //메인메뉴 끝
	      }
	   }

	   public static int scanint(Scanner sc) { //숫자만 입력 다른 글자는X
	      int number =0;
	      
	      while (true) {
	            if (sc.hasNextInt()) {
	                number = sc.nextInt();
	                break;
	            } else {
	                System.out.println("유효한 숫자가 아닙니다. 다시 입력하세요.");
	                System.out.print(">> ");
	                sc.next(); // 잘못된 입력을 소비하여 무한 루프 방지
	            }
	        }
	      
	      return number;
	   }
	}
