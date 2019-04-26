package com.example.smdemo1.dao;

import java.util.List;

import com.example.smdemo1.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xp-dc
 * @date 2018/12/25
 */
@Mapper
public interface UserMapper2 {
	int insert(User user);

	int update(User user);

	User fetch(Integer id);

	List<User> listAllUsers();
}
