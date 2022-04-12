package kr.ac.kopo.chat_stomp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.chat_stomp.model.User;
import kr.ac.kopo.chat_stomp.service.UserService;

@Controller
public class RootController {
	
	@Autowired
	UserService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String login(User item,HttpSession session) {
		
		if(service.login(item)) {
			session.setAttribute("user", item);
			return "redirect:.";
		}
		
		return "redirect:.";
	}
}
