package kr.co.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	
	@RequestMapping(value="/us_join", method=RequestMethod.GET)
	public String usJoinForm() {
		return "/WEB-INF/user/us_join.jsp";
	}

}
