package com.example.smdemo1.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthResourceOrg implements Serializable {
	private static final long serialVersionUID = -8676010552585755093L;

	private Long resourceOrgId;

	private Long resourceId;

	private Long orgId;
}
