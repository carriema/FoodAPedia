package web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.User;
import service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	//Handle request from index.html
	@RequestMapping(value ="/index.html")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		boolean isValidUser = userService.hasMatch(loginCommand.getUseName(), loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "User account or password is not valid.");
		} else {
			User user = userService.findUserByName(loginCommand.getUseName());
			user.setLastIp(request.getRemoteAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
	
}
