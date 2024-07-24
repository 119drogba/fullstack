package exceptex;

public class ExceptEx00 {

//	public static void main(String[] args) {
//		try {
//		Class c = String.class;
//			Class c = Class.forName("String");
//			System.out.println(c);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("시스템 정상 종료");
//	}

public static void main(String [] args) throws ClassNotFoundException,IllegalAccessException {
		Class c1 = Class.forName("String");
		System.out.println(c1);
	}

}
