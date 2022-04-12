package kr.ac.kopo.chat_stomp.service;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.chat_stomp.dao.UserDao;
import kr.ac.kopo.chat_stomp.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	@Override
	public boolean login(User item) {
		
		User user = dao.login(item);
		
		if(user != null) {
			
			user.setUserCode(item.getUserCode());
			user.setUserId(item.getUserId());
			user.setUserPw(null);
			
			return true;
			
		}
		
		return false;
	}

}
