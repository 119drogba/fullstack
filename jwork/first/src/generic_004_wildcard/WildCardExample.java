package generic_004_wildcard;

import java.util.Arrays;

public class WildCardExample {

	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + "수강생:" + Arrays.toString(course.getStudents()));
	}

	public static void registerCourseStudent(Course<? extends Student> course) {

		System.out.println(course.getName() + "수강생:" + Arrays.toString(course.getStudents()));
	}

	public static void registerCourseWorker(Course<? super Worker> course) {

		System.out.println(course.getName() + "수강생:" + Arrays.toString(course.getStudents()));
	}

	public static void main(String[] args) {
		Course<Person> personCourse = new Course<Person>("일반인과정",5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		registerCourse(personCourse);
		
		Course<Worker> workerCourse = new Course<Worker>("직장인과정",5);
		workerCourse.add(new Worker("직장인"));
		registerCourse(workerCourse);
		
		Course<Student> studentCourse = new Course<Student>("학생과정",5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
		registerCourse(studentCourse);
		
		Course<HighStudent> highstudentCourse = new Course<HighStudent>("고등학생과정",5);
		highstudentCourse.add(new HighStudent("고등학생"));
		registerCourse(highstudentCourse);
		
		System.out.println();
		
		//registerCourseStudent(personCourse);   (x)
		//registerCourseStudent(workerCourse);   (x)
		registerCourseStudent(studentCourse);
		registerCourseStudent(highstudentCourse);
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		//registerCourseWorker(studentCourse);  (x)
		//registerCourseWorker(highstudentCourse);  (x)
		
		
		
		
		
		
		
		
		
		

	}

}
