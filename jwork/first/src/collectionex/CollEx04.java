package collectionex;

import java.util.*;

public class CollEx04 {

	public static void main(String[] args) {

		ArrayList<Student> list = new ArrayList<Student>();
//		Student stu = new Student();
//		stu.setName("자바왕");
//		stu.setBan(1);
//		stu.setNo(1);
//		list.add(stu);
//		
//		stu.setName("자바짱");
//		stu.setBan(1);
//		stu.setNo(2);
//		list.add(stu);
//		
//		stu.setName("홍길동");
//		stu.setBan(2);
//		stu.setNo(1);
//		list.add(stu);
//		
//		stu.setName("전우치");
//		stu.setBan(2);
//		stu.setNo(2);
//		list.add(stu);
		
		list.add(new Student("자바왕", 1, 1));
		list.add(new Student("자바짱", 1, 2));
		list.add(new Student("홍길동", 2, 1));
		list.add(new Student("전우치", 2, 2));

		Iterator<Student> it = list.iterator();

		while (it.hasNext()) {
			Student s = it.next();
			System.out.println(s.name + " " + s.ban + "반 " + s.no + "번");
		}

	}
}

class Student {
	String name = "";
	int ban;
	int no;

	Student() {
	}

	public Student(String name, int ban, int no) {
		
		this.name = name;
		this.ban = ban;
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}