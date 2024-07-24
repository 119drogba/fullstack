package first;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int year = 2024;

		System.out.println(year + "년도의 월별 일자 수 출력\n");
		for (int m = 1; m <= 12; m++) {

			switch (m) {
			case 2:
				if (year % 4 == 0)
					System.out.println(m + "월: 29일");
				else
					System.out.println(m + "월: 28일");
				break;

			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println(m + "월: 30일");
				break;
			default:
				System.out.println(m + "월: 31일");
				break;
			}
		}

	}
}
