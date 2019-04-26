package com.example.smdemo1.model;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthPermission extends BaseModel{
	private static final long serialVersionUID = -5264659152278625060L;

	private Long permissionId;

	/**
	 * 权限名称
	 */
	private String permissionName;

	/**
	 * 资源id
	 */
	private Long resourceId;

	/**
	 * 操作id
	 */
	private Long operationId;

	/**
	 * 父权限id
	 */
	private Long permissionPid;

	/**
	 * 系统id
	 */
	private Long systemId;
}
