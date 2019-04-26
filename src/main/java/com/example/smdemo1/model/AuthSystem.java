package com.example.smdemo1.model;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthSystem extends BaseModel {
	private static final long serialVersionUID = -6844449392961480426L;

	private Long systemId;

	/**
	 * 系统名称
	 */
	private String systemName;

	/**
	 * 系统描述
	 */
	private String systemDesc;

	/**
	 * 系统菜单资源类型id
	 */
	private Integer systemMenuResourceTypeId;
}
