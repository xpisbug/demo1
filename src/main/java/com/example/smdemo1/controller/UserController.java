package com.example.smdemo1.controller;

import com.example.smdemo1.dto.response.BaseResponseDTO;
import com.example.smdemo1.model.AuthUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Slf4j
@RestController
@RequestMapping("user")
@Api(tags = "UserController", description = "用户管理")
public class UserController {

	@PostMapping("add")
	@ApiOperation("添加用户")
	public BaseResponseDTO<Integer> add(AuthUser authUser){
		return null;
	}

	@GetMapping("fetch/{userId}")
	@ApiOperation("查询某个用户")
	public BaseResponseDTO<AuthUser> fetch(@ApiParam("用户id") @PathVariable Long userId){
		return null;
	}

	@PostMapping("update")
	@ApiOperation("更新用户")
	public BaseResponseDTO<Integer> update(AuthUser authUser){
		return null;
	}
}
