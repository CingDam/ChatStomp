package kr.ac.kopo.chat_stomp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
	public String list(Model model,@SessionAttribute User item) {
		
		
		List<Room> list = service.list(item.getUserCode());
		
		model.addAttribute("list",list);
		
		model.addAttribute("userId", item.getUserId());
		
		return path+"list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	@PostMapping("/add")
	public String add(Room item) {
		service.add(item);
		return "redirect:.";
	}
	
	@GetMapping("/delete/{roomCode}")
	public String delete(@PathVariable int roomCode){
		service.delete(roomCode);
		return "redirect:.";
	}
}
