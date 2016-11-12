package com.food.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.food.domain.User;
import com.food.service.UserService;
@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/register.html")
	public String registerPage() {
		return "register";
	}
	@RequestMapping(value="/registerCheck.html")
	public ModelAndView Register(HttpServletRequest request, RegistInfo info) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/main");
		boolean isExist = userService.hasUser(info.getUserAccount());
		if (isExist) {
			return new ModelAndView("/register", "error", "User account already existed.");
		} else if (!info.getPassword().equals(info.getRepassword())){
			return new ModelAndView("/register", "error", "Password is not the same.");
		}
		User user = new User();
		user.setUserAccount(info.getUserAccount());
		user.setPassword(info.getPassword());
		user.setLastIp(request.getRemoteAddr());
		user.setLastVisit(new Date());
		userService.register(user);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return view;
	}

}
