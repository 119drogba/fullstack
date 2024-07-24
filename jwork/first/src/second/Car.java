package second;

public class Car { 

	//멤버필드 = 멤버변수
	private String modelName;
	private int modelYear;
	private String color;
	private int maxSpeed;
	private int currentSpeed;
	
	
	Car(String modelName, int modelYear, String color, int maxSpeed) {
		this.modelName = modelName;  //.은 멤버로 접근
		this.modelYear = modelYear;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.currentSpeed = 0;   //클래스랑 이름이 같고 리턴타입이 없다
	}
	
	Car() {                                //기본생성자 호출문
		this("소나타", 2012,"검정색", 160);
		
	
	}

	public String getModel() {     //메소드 선언문 (리턴타입존재)
		return this.modelYear +"년식" + this.modelName +"" +this.color;
	}
}
