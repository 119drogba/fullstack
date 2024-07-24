package inheritance;

import third.DifferSuperClass;

public class DifferSubClass extends DifferSuperClass {

	public void subMd() {
		md();
	}

	public static void main(String[] args) {

		DifferSubClass sp = new DifferSubClass();
		System.out.println(sp.sameVar);

	}

}
