package kr.ac.kopo.chat_stomp.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

public class Room {
	private int roomCode;
	private String userId;
	private String roomName;
	private Set<WebSocketSession> sessions = new HashSet();
	
	public int getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	
}
