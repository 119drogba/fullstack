package com.springbook.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping("/join.do")
	public String userInsert(UserVO vo) {
		userService.userInsert(vo);
		return "redirect:login.jsp?result=1";
	}

	@RequestMapping("/selUser.do")
	public String selUser(UserVO vo, Model model) {
		model.addAttribute("user", userService.selUser(vo));
		return "/WEB-INF/user/selUser.jsp";
	}

	@RequestMapping("/delUser.do")
	public String userDelete(UserVO vo, HttpSession session) {
		userService.userDelete(vo);
		session.invalidate();
		return "redirect:index.jsp";
	}

	@RequestMapping("/updateUser.do")
	public String userUpdate(UserVO vo) {
		System.out.println("update vo: " + vo);
		userService.userUpdate(vo);
		return "redirect:selUser.do?id=" + vo.getId();
	}

	@RequestMapping("/userList.do")
	public String getUserList(@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword, Model model) {
		model.addAttribute("userList", userService.getUserList(keyword));
		return "/WEB-INF/user/userList.jsp";
	}

	@GetMapping(value = "/login.do")
	public String loginView(@ModelAttribute UserVO vo) {
		vo.setId("admin");
		vo.setPassword("1111");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		vo = userService.login(vo);
		if (vo != null) {
			session.setAttribute("userId", vo.getId());
			session.setAttribute("userName", vo.getName());
			session.setAttribute("userRole", vo.getRole());
			return "getBoardList.do";
		} else {
			return "login.jsp?error=1";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login.jsp";
	}
}