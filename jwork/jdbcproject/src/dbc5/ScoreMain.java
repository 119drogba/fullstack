package dbc5;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {

		String ch;
		Score ob = new Score();
		Scanner sc = new Scanner(System.in);

		try {
			while (true) {

				System.out.println("1.입력 2.수정 3.삭제 4.이름검색 5.전체출력 6.종료=>");
				ch = sc.nextLine();    //공백을 포함한 한줄 문자열

				switch (ch.replace(" ", "")) {

				case "1":
				case "입력":
					if (ob.insertDate() != 0)
						System.out.println("입력 성공!");
					break;
				case "2":
				case "수정":
					if (ob.updateDate() != 0)
						System.out.println("수정 성공!");
					else
						System.out.println("수정 실패!");
					break;

				case "3":
				case "삭제":
					if (ob.deleteDate() != 0)
						System.out.println("삭제 성공!");
					else
						System.out.println("삭제 실패!");
					break;
				case "4":
				case "이름검색":
					ob.selectName();
					break;
				case "5":
				case "전체출력":
					ob.selectAll();
					break;
				case "6":
					System.out.println("종료되었습니다.");
					DBConn.close();
					System.exit(0);

				}

			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
