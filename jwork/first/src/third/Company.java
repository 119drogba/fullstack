package third;

public class Company {

	private static Company instance;

	private Company() {
	}
	// private static int count = 0;

	public static Company getInstance() {
		if (instance == null) {
			instance = new Company();
		}

		// count++;
		// System.out.println(count);
		return instance;
	}

}
