package kr.ac.kopo.chat_stomp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.chat_stomp.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public User login(User item) {
		return sql.selectOne("user.login",item);
	}
	
	
}
