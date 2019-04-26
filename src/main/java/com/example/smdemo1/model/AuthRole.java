package com.example.smdemo1.model;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthRole extends BaseModel {
	private static final long serialVersionUID = 8551410928542146890L;

	private Long roleId;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色描述
	 */
	private String roleDesc;

	/**
	 * 父角色id
	 */
	private Long rolePid;

	/**
	 * 组织id
	 */
	private Long orgId;

	/**
	 * 系统id
	 */
	private Long systemId;

	/**
	 * 角色关联id
	 */
	private Long roleRefId;
}
