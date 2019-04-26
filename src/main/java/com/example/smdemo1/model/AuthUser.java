package com.example.smdemo1.model;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthUser extends BaseModel {
	private static final long serialVersionUID = -2611029471779342985L;

	private Long userId;

	@ApiParam("用户名称")
	private String userNickName;

	@ApiParam("用户账号")
	private String userName;

	//@ApiParam("用户密码")
	private String userPassword;

	@ApiParam("Email")
	private String email;

	@ApiParam("用户电话")
	private String userTel;

	@ApiParam("用户描述")
	private String userDesc;

	@ApiParam("组织id")
	private Long orgId;

	@ApiParam("系统id")
	private Long systemId;

	@ApiParam("用户关联id")
	private Long userRefId;
}
