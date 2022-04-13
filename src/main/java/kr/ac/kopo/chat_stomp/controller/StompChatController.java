package kr.ac.kopo.chat_stomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.chat_stomp.model.ChatMessage;

@Controller
@RequestMapping("/stomp")
public class StompChatController {
	
	private SimpMessagingTemplate template;
	
	@MessageMapping("/chat/enter")
	public void enter(ChatMessage msg) {
		
		msg.setMessageContents(msg.getUserId()+"님이 입장하였습니다.");
		template.convertAndSend("/sub/chat_romm/view" + msg.getRoomCode(), msg);
	}
	
	@MessageMapping("/chat/message")
	public void message(ChatMessage msg) {
		template.convertAndSend("/sub/chat/room"+msg.getRoomCode(),msg);
	}
	

}
