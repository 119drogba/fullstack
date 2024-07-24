package dbc4;

import java.util.ArrayList;
import java.util.Scanner;

public class TB_MEMBER_EX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TB_MEMBER_DAO dao = new TB_MEMBER_DAO();
		boolean tf = false;
		// 회원가입

		while (true) {
			System.out.println("회원가입 시작");
			System.out.println("아이디입력>>");
			String mid = sc.next();

			System.out.println("비밀번호입력>>");
			String mpw = sc.next();

			System.out.println("이메일 입력 선택 1.예  2.아니오 ");
			int yn = sc.nextInt();
			String mml = null;

			if (yn == 1) {
				System.out.println("이메일입력>>");
				mml = sc.next();
			}
			System.out.println("핸드폰번호 입력 선택 1.예  2.아니오 ");
			yn = sc.nextInt();
			String mph = null;
			if (yn == 1) {
				System.out.println("핸드폰번호입력>>");
				mph = sc.next();
			}
			if (mid == null || mid.equals("") || mpw == null || mpw.equals("")) {
				continue;
			} else {
				int cnt = dao.join(mid, mpw, mml, mph);
				if (cnt > 0) {
					System.out.println("회원가입 성공");
					break;
				} else {
					System.out.println("회원가입 실패");
					continue;
				}
			}
		}

		// 로그인
		while (true) {

			System.out.print("아이디 입력 >> ");
			String id = sc.next(); // "apple"

			System.out.println("비밀번호 입력 >> ");
			String pw = sc.next(); // "1111"

			TB_MEMBER_VO vo = dao.login(id, pw);
			System.out.println("vo: " + vo);

			if (vo != null) {
				tf = true;
				System.out.println("로그인 성공");
				break;
			} else {
				System.out.println("정보가 일치하는 회원이 없습니다.");
			}

		}
		// 전체회원 목록 조회
		System.out.println("전체회원 목록 조회");
		if (tf) {
			ArrayList<TB_MEMBER_VO> mList = dao.memberList();
			if (mList.size() > 0) {
				for (TB_MEMBER_VO mvo : mList) {
					System.out.printf("아이디:%s, 비밀번호:%s,이메일:%s \n", mvo.getM_userid(), mvo.getM_pwd(), mvo.getM_email());

				}

			} else {
				System.out.println("회뭔 목록이 없습니다.");
			}

		}

		while(true) {
			System.out.println("회원 삭제");
			String id = sc.next();
		}
		
	}
}
