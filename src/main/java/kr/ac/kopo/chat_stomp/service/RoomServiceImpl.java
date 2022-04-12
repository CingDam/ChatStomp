package kr.ac.kopo.chat_stomp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.chat_stomp.dao.RoomDao;
import kr.ac.kopo.chat_stomp.model.Room;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomDao dao;
	
	@Override
	public List<Room> list() {
		return dao.list();
	}

	@Override
	public void add(Room item) {
		dao.add(item);

	}

	@Override
	public void delete(int roomCode) {
		dao.delete(roomCode);

	}

}
