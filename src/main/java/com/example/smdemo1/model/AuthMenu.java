package com.example.smdemo1.model;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class AuthMenu extends BaseModel {
	private static final long serialVersionUID = 4420361228419453632L;

	private Long menuId;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 菜单地址
	 */
	private String menuUrl;

	/**
	 * 菜单描述
	 */
	private String menuDesc;

	/**
	 * 是否可以展开，0不展开，1展开
	 */
	private Integer menuIsExpand;

	/**
	 * 菜单排序
	 */
	private Long menuSortNo;

	/**
	 * 父菜单id
	 */
	private Long menuPid;
}
