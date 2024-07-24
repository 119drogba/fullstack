package third;

public class Wrap02 {
	
	public static void main (String [] args ) {
		
		int i =50;
		double d = i;
		
		Integer w_i = 50;
		//Double w_d = (double) i; //(o 가능)
		Double w_d = (double) w_i; // (o 가능)
		//Double w_d = (Double) w_i; //(x 불가능)
		System.out.println(w_d);//(o 가능)
		
		String str = String.valueOf(i);
		
		char c = '가';
		str = String.valueOf(c);
		boolean b = true;
		str =String.valueOf(b);
		
		String s = "true";
		boolean b1 = Boolean.parseBoolean(s);
		System.out.println(b1);
		
		for(int x = 0; x<s.length();x++) {
			char c1 = s.charAt(x);
			System.out.println(c1);
		}
		
	} 

}

