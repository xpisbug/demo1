package com.example.smdemo1.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthRolePermission implements Serializable{
	private static final long serialVersionUID = 3532296124357843408L;

	private Long rolePermissionId;

	private Long roleId;

	private Long permissionId;
}
