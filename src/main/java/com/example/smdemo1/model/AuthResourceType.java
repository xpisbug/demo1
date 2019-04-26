package com.example.smdemo1.model;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthResourceType extends BaseModel {

	private static final long serialVersionUID = 2232395578900036391L;

	private Long typeId;

	/**
	 * 资源类型名称
	 */
	private String typeName;

	/**
	 * 资源实体类名
	 */
	private String typeClassName;

	/**
	 * 资源实体父节点属性名
	 */
	private String typeParentFieldName;

	/**
	 * 资源实体主键属性名
	 */
	private String typePkFieldName;

	/**
	 * 系统id
	 */
	private Long systemId;
}
