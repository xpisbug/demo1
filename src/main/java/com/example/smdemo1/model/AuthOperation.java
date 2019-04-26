package com.example.smdemo1.model;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthOperation extends BaseModel{
	private static final long serialVersionUID = 1821832469776299072L;

	private Long operationId;

	/**
	 * 操作名称
	 */
	private String operationName;

	/**
	 * 操作描述
	 */
	private String operationDesc;

	/**
	 * 资源类型id
	 */
	private Long resourceTypeId;

	/**
	 * 系统id
	 */
	private Long systemId;
}
