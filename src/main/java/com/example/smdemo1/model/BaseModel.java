package com.example.smdemo1.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Data
public class BaseModel implements Serializable {
	private static final long serialVersionUID = 5648517437789833257L;

	/**
	 * 创建人
	 */
	private String creationUser;

	/**
	 * 创建时间
	 */
	private Date creationDate;

	/**
	 * 最后修改时间
	 */
	private Date lastChangedDate;

}
