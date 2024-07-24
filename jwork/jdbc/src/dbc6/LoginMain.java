package dbc6;

import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);  //콘솔창에 입력할수있는 객체 생성
		LoginSVC loginSVC = new LoginSVC();
		int selNum = 0;   //

		while (true) {  //제어문 없으면 무한 반복

			if (selNum == 0) {
				System.out.println("메뉴를 선택해 주세요.");
				System.out.println("로그인은 1번, 회원가입은 2번, 회원탈퇴는 3번," + "프로그램 종료는 4번을 입력해주세요.");

				selNum = sc.nextInt(); //공백이없는 숫자값으로 받음 (엔터삭제)
			} else if (selNum == 1) {
				// 로그인
				System.out.println("로그인 메뉴");
				System.out.println("아이디와 비밀번호를 입력하세요.");

				System.out.println("아이디 : ");
				String id = sc.next().toLowerCase();

				System.out.println("비밀번호 : ");
				String passwd = sc.next().toLowerCase();

				User user = loginSVC.login(id, passwd);
				if (user == null) {
					System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
					System.out.println("다시 입력은 1번, 회원가입은 2번, 취소는 3번," + "프로그램 종료는 4번을 눌러주세요.");
					int sel = sc.nextInt();
					if (sel == 1)
						selNum = 1;
					else if (sel == 2)
						selNum = 2;
					else if (sel == 3)
						selNum = 0;
					else
						selNum = 4;

				} else {
					System.out.println("로그인 완료!!");
					System.out.println("로그인한 사용자 정보");
					System.out.println(user);
					selNum = 0;
				}
			} else if (selNum == 2) {
				System.out.println("회원가입 메뉴");
				System.out.println("아이디 입력:");
				String id = sc.next().toLowerCase();

				System.out.println("비번 입력: ");
				String pw = sc.next().toLowerCase(); // 소문자로

				sc.nextLine(); // 한줄읽어오기

				System.out.println("이름 입력: ");
				String nm = sc.nextLine().toLowerCase();

				System.out.println("입력완료 : 1번, 다시 입력: 2번, 취소는 3번, " + "프로그램 종료는 4번을 입력해 주세요.");
				int sel = sc.nextInt();
				if (sel == 1) {
					int c = loginSVC.insertMember(id, pw, nm);
					if (c > 0) {
						System.out.println("회원가입이 완료되었습니다");
						selNum = 0;
					} else {
						System.out.println("다시 입력해주십시오.");
						selNum = 2;
					}

				}

				else if (sel == 2) {
					selNum = 2;
				} else if (sel == 3) {
					selNum = 0;
				} else {
					selNum = 4;
				}

			} else if (selNum == 3) {
				// 회원탈퇴메뉴
				System.out.println("회원 탈퇴 메뉴");
				System.out.println("회원탈퇴를 하시려면 1번, 취소는 2번," + "프로그램 종료는 3번을 입력해주세요");
				int sel = sc.nextInt();
				if (sel == 1) {
					System.out.print("탈퇴할 아이디 입력: ");
					String id = sc.next().toLowerCase();
					int c = loginSVC.deleteMember(id);

					if (c > 0) {
						System.out.println("회원탈퇴 완료");
						selNum = 0;
					} else {
						System.out.println("탈퇴가 되지 않았습니다.");
					}
				} else if (sel == 2) {
					selNum = 0;
				} else {
					selNum = 4;
				}
			} else {
				return;   //리턴을 감싸고 있는 메소드 밖으로 (종료)   //return 5; 값도 전달하고 메소드 밖으로 종료
			}

		}
	}

}
