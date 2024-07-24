package third;

public class Box1 {
	
	int width;
	int height;
	int depth;
	long idNum;
	static long boxID=100;
	
	static long getcurrentID() {
		return ++boxID;
	}

}
