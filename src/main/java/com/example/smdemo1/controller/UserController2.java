package com.example.smdemo1.controller;

import javax.annotation.Resource;

import com.example.smdemo1.annoation.Log;
import com.example.smdemo1.annoation.LogDu;
import com.example.smdemo1.model.User;
import com.example.smdemo1.service.UserService2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xp-dc
 * @date 2018/12/25
 */
@RestController
@Api(tags = {"user"}, description = "用户测试")
public class UserController2 {

	/*@Resource
	private User user;
*/
	@Resource
	private UserService2 userService2;

	/*@RequestMapping("/hello")
	public String hello(){
		return user.getId()+":"+user.getName()+"--"+user.getAge()+"_"+user.getDesc();
	}*/

	@LogDu
	//@OperLog(module = @Log, method = "/add")
	@PostMapping("/add")
	@ApiOperation("新增用户")
	public int insertUser(@Log User user){
		User user1 = user;
		return userService2.insertUser(user1);
	}

	@RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
	@LogDu
	@ApiOperation(value = "根据用户id查询",notes = "fetch")
	public User fetch(@PathVariable Integer id){
		User result = null;
		try{
			result = userService2.fetch(id);
			if(result != null)
				throw new Exception("给你一个异常");
			//return user;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("exception :"+e);
			//throw new RuntimeException(e);
			//return user;
		}
		System.out.println("999999999999999999999");

		return result;
	}
}
