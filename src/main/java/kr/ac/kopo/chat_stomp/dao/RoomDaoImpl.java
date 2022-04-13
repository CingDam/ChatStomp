package kr.ac.kopo.chat_stomp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.chat_stomp.model.Room;

@Repository
public class RoomDaoImpl implements RoomDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Room> list() {
	
		return sql.selectList("room.list");
	}

	@Override
	public void add(Room item) {
		sql.insert("room.add", item);
		
	}

	@Override
	public void delete(int roomCode) {
		sql.delete("room.delete", roomCode);
		
	}

	@Override
	public Room item(int roomCode) {
		
		return sql.selectOne("room.item",roomCode);
	}

}
