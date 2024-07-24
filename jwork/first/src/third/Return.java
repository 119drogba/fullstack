package third;

public class Return {
	
	public String say_nick(String nick) {
		if ("fool".equals(nick)) {
			//return키워드의 또 다른 쓰임새, 메소드의 종료 중괄호로 빠져나감.
			
			return "ok";
		}
		System.out.println("나의 별명은"+nick+"입니다.");
		return "no";
	}

}
