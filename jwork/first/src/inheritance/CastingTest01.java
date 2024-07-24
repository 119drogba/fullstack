package inheritance;

public class CastingTest01 {

	public static void main(String[] args) {

		// 레퍼런스 student를 이용하면 name, dept에 접근 가능
		Student student = new Student("Duly");
		System.out.println(student.name);

		// Student 객체의 멤버 중 오직 Person 클래스의 멤버만 접근이 가능
		Person person = student;
		person.name = "Cogildong";
		System.out.println(person.name);
	}

}

class Person {

	String name;

	public Person(String name) {
		this.name = name;
	}
}

class Student extends Person {
	String dept;

	public Student(String name) {
		super(name); //부모 기타생성자 호출문
	}
}