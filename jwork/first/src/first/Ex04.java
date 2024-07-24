package first;

public class Ex04 {

	
	public static int calc(int a,String s ,int b) {
		int result = 0;
		
		switch(s) {
		
		case "+" : result = a+b; break;
		case "x" : result = a*b;break;
		case "/" : result = a/b; break;
		case "%" : result = a-b; break;
		default : result = a%b;
		
		}
		return result;
	}
		
		
		
	
	
	public static void main(String[] args) {
		
		
	     int result = calc(10, "/",5);
	     System.out.println(result);
	     
	     result = calc(5, "x",10);
	     System.out.println(result);
	     
	     result = calc(10, "/",10);
	     System.out.println(result);
	     
	     result = calc(10, "%",5);
	     System.out.println(result);
	    
	     result = calc(5, "-",10);
	     System.out.println(result);
	    
	    
	    
		
	}
}
