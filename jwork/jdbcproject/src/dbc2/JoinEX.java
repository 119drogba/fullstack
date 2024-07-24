package dbc2;

import java.sql.*;
import java.util.Scanner;

public class JoinEX {
	//유효성검사 : 영어대소문자, 숫자만 입력가능한 경우 체크
	public static int cntResult(String str) {
		int cnt = 0;
		for(int i=0; i < str.length() ; i++) {
			int aciiCode = (int) str.charAt(i);
			if(aciiCode < 48 ) {
				cnt++;
				break;
			}
			if(aciiCode >57 && aciiCode < 65){
				cnt++;
				break;
			}
			if(aciiCode > 90 && aciiCode < 97){
				cnt++;
				break;
			}
			if(aciiCode > 122){
				cnt++;
				break;
			}
		}
		
		return cnt;
	}
	
	//유효성검사 - 문자열 길이 값 체크
	public static int strLenChk(String str, int limit) {
		int cnt = 0;
		int lenByte = 0;
		for(int i = 0; i < str.length(); i++) {
			int code = (int) str.charAt(i);
			if(code < 128) lenByte= lenByte+1; 
			else lenByte = lenByte+3;
		}
		if(lenByte > limit) {
			System.out.printf("최대 %dByte 이하로 입력하셔야 합니다.\n", limit);
			cnt++;
		}		
		return cnt;
	}
	
	//유효성검사 - 한글인 경우 가-힣 사이의 글자만 입력 가능하도록 체크 
	public static int hangleChk(String str) {
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			int code = (int) str.charAt(i);
			if(code >= 12593 && code <= 12643) {
				System.out.println("한글은 자음만 또는 모음만 입력하실 수 없습니다.");
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		
	
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1. 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. Connection객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "TEST", "1111"
			);
			//3. 명령문 객체 생성 
			String sql ="insert into member (mid, mpw, mnm, mph, mzip, maddr) "+
			"values (?, ? ,?, ? ,?, ?)";
			ps = conn.prepareStatement(sql);
			
			//4. 명령문 실행
			Scanner sc = new Scanner(System.in);
			info:
			while(true) {
				System.out.println("회원가입 메뉴");
				System.out.println("다음 메뉴 중 선택하세요.");
				System.out.println("1.회원가입 2. 시스템종료");
				
				int ys = sc.nextInt();
				if(ys == 1) {
					//0-9: 48~57; A-Z: 65~90 a-z: 97~122
					while(true) {
						System.out.print("아이디(영어대소문자,숫자포함20자이내)>>");
						String mid = sc.next();
						
						if(cntResult(mid) == 0 && strLenChk(mid, 20) == 0) {
							ps.setString(1 , mid);
							break;
						}else {
							System.out.println("영어대소문자, 숫자만 입력하실 수 있습니다.");
						}
					}
					
					while(true) {
						System.out.print("비밀번호(영어대소문자,숫자포함20자이내)>>");
						String mpw = sc.next();
						if(cntResult(mpw) == 0  && strLenChk(mpw, 20) == 0) {
							ps.setString(2 , mpw);
							break;
						}else {
							System.out.println("영어대소문자, 숫자만 입력하실 수 있습니다.");
						}
					}
					
					sc.nextLine(); //String mpw = sc.next();의 엔터를 상쇄시키기 위해 기술
					while(true) {
						System.out.print("이름입력>>");
						String mnm = sc.nextLine();
						if(strLenChk(mnm, 200) == 0 && hangleChk(mnm) == 0 ) {
							ps.setString(3 , mnm);
							break;
						}
					}
					
					while(true) {
						System.out.print("전화번호입력(예: 01012341234)>>");
						String mph = sc.next();
						if(strLenChk(mph, 11) == 0) {
							ps.setString(4 , mph);
							break;
						}
					}
					
					System.out.print("우편번호입력(예: 12345)>>");
					System.out.println("입력여부 선택: 1.예  2.아니오");
					int yes_no = sc.nextInt();
					if(yes_no == 1){
						while(true) {
							System.out.print("우편번호입력>>");
							String mzip = sc.next();
							if(strLenChk(mzip, 11) == 0) {
								ps.setString(5 , mzip);
								break;
							}
						}
					}else {
						ps.setString(5 , "");
						System.out.println();
					}
					
					sc.nextLine(); //String mzip = sc.next();의 엔터를 상쇄시키기 위해 기술
					System.out.print("주소 입력>>");
					System.out.println("입력여부 선택: 1.예  2.아니오");
					yes_no = sc.nextInt();
					if(yes_no == 1){
						sc.nextLine(); //sc.nextInt();의 엔터 상쇄
						while(true) {
							System.out.print("주소 입력>>");
							String maddr = sc.nextLine();
							if(strLenChk(maddr, 200) == 0) {
								ps.setString(6 , maddr);
								break;
							}
						}
					}else {
						ps.setString(6 , "");
					}
					
					while(true) {
						System.out.println("다음 중 선택하세요.");
						System.out.println("1.입력완료 2.다시입력 3.시스템종료");
						int result = sc.nextInt();
						switch(result) {
						case 1 : 
							int rowCount = ps.executeUpdate();
							if(rowCount > 0 ) System.out.println("회원가입 완료");
							else System.out.println("회원가입 실패");
							continue info;
						case 2 : 
							System.out.println("입력했던 데이터는 모두 초기화 됩니다.");
							continue info;
						case 3 :
							break info;
						default : 
							System.out.println("잘못된 값을 입력하셨습니다.");
							continue;
						}
					}
					
				}else {
					break;
				}
				
			}
			
			System.out.println("시스템이 종료되었습니다.");
			
			
		}catch(Exception e) {
			System.out.println("드라이버 연결실패 또는 SQL명령 오류");
		}finally {
			//5. 객체 닫기
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				System.out.println("객체 닫기 오류");
			}
		}
		
	}

}