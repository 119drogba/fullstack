package second;


class Sub {
	int modelYear;
	String modelName;
	
	public Sub(int year, String name) {
		modelYear = year;
		modelName = name;
	}
}



//SubEx 메인클래스 시작
public class SubEx {

	public static void main(String[] args) {
		Sub myCar  = new Sub(2022, "Volvo");
		System.out.println("년식: " + myCar.modelYear+ ",차종:" +myCar.modelName);

	}

}
//SubEx 메인클래스 종료