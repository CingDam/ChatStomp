package kr.ac.kopo.chat_stomp.dao;

import java.util.List;

import kr.ac.kopo.chat_stomp.model.Room;

public interface RoomDao {

	List<Room> list();

	void add(Room item);

	void delete(int roomCode);

}
