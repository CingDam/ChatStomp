package kr.ac.kopo.chat_stomp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.chat_stomp.model.Room;
import kr.ac.kopo.chat_stomp.model.User;
import kr.ac.kopo.chat_stomp.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	final String path = "room/" ;
	
	@Autowired
	RoomService service;
	
	@RequestMapping({"/","list"})
	public String list(Model model,HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		System.out.println(user.getUserId());
		
		List<Room> list = service.list();
		
		model.addAttribute("list",list);
		
		return path+"list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	@PostMapping("/add")
	public String add(Room item,HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		System.out.println(user.getUserId());
		System.out.println(item.getRoomName());
		
		item.setUserId(user.getUserId());
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/delete/{roomCode}")
	public String delete(@PathVariable int roomCode){
		service.delete(roomCode);
		return "redirect:..";
	}
	
	@GetMapping("chat_room/{roomCode}")
	public String view(@PathVariable int roomCode,Model model) {
		
		Room item = service.item(roomCode);
		
		model.addAttribute("item",item);
		
		return path + "view";
	}
}
