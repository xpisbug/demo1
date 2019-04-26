package com.example.smdemo1.service;

import javax.annotation.Resource;

import com.example.smdemo1.dao.UserMapper2;
import com.example.smdemo1.model.User;
import org.springframework.stereotype.Service;

/**
 * @author xp-dc
 * @date 2018/12/25
 */
@Service
public class UserService2 {

	@Resource
	private UserMapper2 userMapper2;

	public int insertUser(User user){
		if(user == null){
			return -1;
		}
		if(user.getName() == null || "".equals(user.getName())){
			return 0;
		}
		return userMapper2.insert(user);
	}

	public User fetch(Integer id){
		if(id == null || id <= 0){
			return null;
		}
		return userMapper2.fetch(id);
	}
}
