package com.example.smdemo1.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthUserRole implements Serializable {
	private static final long serialVersionUID = -7128406057911179073L;

	private Long userRoleId;

	private Long userId;

	private Long roleId;
}
