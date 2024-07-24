package inheritance;

public class Super01 {
	
	public static void main (String [] args ) {
		
		Ch3 d = new Ch3();
		d.write();
	}

}

class Pa3{
	int x = 1000; //x
	
	void display () { //x
		System.out.println("상위클래스 display");
	}
}


class Ch3 extends Pa3 {
	int x = 2000;  //o
	
	void display() { //o => 오버라이트
		System.out.println("하위클래스 display()");
	}
	
	void write() { //o
		super.display(); //상위, 기본 , 부모   //하위 , 파생 ,sub
		this.display();
		System.out.println("super.x:"+super.x);
		System.out.println("this.x:"+x);
		
	}
}
