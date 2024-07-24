package generic_002_yes;

public class Car {
	String carName;
	String carProduct;
	int carYear;
	int maxLoad;
	
	public Car() {} 
	
	//생성자 만들기 alt + shift + s 키 => Generate Constructor using Fields 선택 (마우스 우버튼 =>Source
		//체크되어 있는 필드 모두 그대로 둘 것 = > Generete
	
	//Getter, Setter 만들기 alt + shift + s 키 => Generate Getters and Setters선택
	//체크되어 있는 필드 모두 그대로 둘 것 = > Generete
	public String getCarName() {
		return carName;
	}
	public Car(String carName, String carProduct, int carYear, int maxLoad) {
		
		this.carName = carName;
		this.carProduct = carProduct;
		this.carYear = carYear;
		this.maxLoad = maxLoad;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarProduct() {
		return carProduct;
	}
	public void setCarProduct(String carProduct) {
		this.carProduct = carProduct;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public int getMaxLoad() {
		return maxLoad;
	}
	public void setMaxLoad(int maxLoad) {
		this.maxLoad = maxLoad;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", carProduct=" + carProduct + ", carYear=" + carYear + ", maxLoad="
				+ maxLoad + "]";
	}

}
