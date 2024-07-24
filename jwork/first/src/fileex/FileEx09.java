package fileex;

import java.io.File;

public class FileEx09 {

	public static void main(String[] args) {
		try {
			File f = new File("c:/jwork/first/src/fileEx", "FileEx01_00.java");

			System.out.println(f.getName());
			System.out.println(f.exists());
			System.out.println(f.length());

			// boolean result = new File("c:/jwork/Exam/log").mkdir(); //폴더 1단
			// boolean result = new File("c:/jwork/Exam").mkdir();
			boolean result = new File("c:/jwork/Exam/log").mkdirs(); //폴더 여러개

			if (result == true) {
				System.out.println("Exam 디렉토리 생성 성공");
			} else {
				System.out.println("Exam 디렉토리 생성 실패");
			}
			//File[] fArr = new File("c:/jwork/Exam").listFiles();
			String[] listing = new File("c:/jwork/Exam").list(); // list는 이름
			for (String x : listing) {
				System.out.println("디렉토리 목록:" + x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
