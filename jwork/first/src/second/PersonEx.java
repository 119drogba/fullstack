package second;

public class PersonEx {

	public static void main(String[] args) {
		Person noName = new Person();
		System.out.println(noName.name);
		System.out.println(noName.age);

		Person p = noName.returnItSelf();
		System.out.println(p);
		System.out.println(noName);

	}

}

class Person {
	String name; // 클래스 선언문
	int age;

	Person() {
		this("이름 없음", 1);
	}

	Person(String name, int age) { // 생성자 선언문
		this.name = name;
		this.age = age;

	}

	Person returnItSelf() { // 메소드 선언문
		return this;
	}

}
