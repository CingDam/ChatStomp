package kr.ac.kopo.chat_stomp.service;

import java.util.List;

import kr.ac.kopo.chat_stomp.model.Room;

public interface RoomService {

	List<Room> list(int userCode);

	void add(Room item);

	void delete(int roomCode);

}
