package second;

public class MyDate {

	private int y, m, d; //y=0; m=0; d=0;
	private String str;  //str= null;

	private void setMyDate(int r) {
		if (r == 1)
			str = "유효한 날짜입니다.";
		else
			str = "유효하지 않은 날짜입니다.";
	}

	public String getMyDate() {
		return str;
	}
	private MyDate() {}

	public MyDate(int d, int m, int y) {
		this.y = y;
		this.m = m;
		this.d = d;
	}

	public void isValid() {
		int r;
		switch (m) {
		case 4:
			case6: case9: case11: r = (d <= 30) ? 1 : 0;
			break;
		case 2:
			if (y % 4 == 0) {
				r = (d <= 29) ? 1 : 0;
			} else {
				r = (d <= 28) ? 1 : 0;
			}
			break;
		default:
			r = (d <= 31) ? 1 : 0;
		}

		setMyDate(r);
	}
}
