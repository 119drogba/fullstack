package fileex;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx06 {

	public static void main(String[] args) {

		String currDir = System.getProperty("user.dir"); //C:/jwork/first
		File dir = new File(currDir);
		File[] files = dir.listFiles();

		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String attribute = "";
			String size = "";

			if (files[i].isDirectory()) {
				attribute = "DIR";
			} else {
				size = f.length() + "";
				attribute = f.canRead() ? "R" : " ";
				attribute += f.canWrite() ? "W" : " ";
				attribute += f.isHidden() ? "H" : " ";

			}

			System.out.printf("최종 수정일: %s, 파일속성:%3s," + "용량:%6s바이트, 파일명: %s\n", df.format(new Date(f.lastModified())),
					attribute, size, name);
		}
		;

	}

}
