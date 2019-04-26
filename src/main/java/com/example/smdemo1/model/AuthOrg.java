package com.example.smdemo1.model;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthOrg extends BaseModel {
	private static final long serialVersionUID = -393479766723679742L;

	private Long orgId;

	/**
	 * 组织类型
	 */
	private Integer orgType;

	/**
	 * 系统id
	 */
	private Long systemId;

	/**
	 * 引用id
	 */
	private Long orgRefId;

	/**
	 * 组织名称
	 */
	private String orgName;

	/**
	 * 组织描述
	 */
	private String orgDesc;
}
