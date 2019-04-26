package com.example.smdemo1.model;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthResource extends BaseModel {
	private static final long serialVersionUID = -5194230499564825451L;

	private Long resourceId;

	/**
	 * 资源名称
	 */
	private String resourceName;

	/**
	 * 资源类型id
	 */
	private Long resourceTypeId;

	/**
	 * 父资源id
	 */
	private Long resourcePid;
}
