package com.example.smdemo1.dao;

import java.util.Date;

import lombok.Data;

/**
 * @author xp-dc
 * @date 2018/12/26
 */
@Data
public class Log {

	private Long id;
	//操作人
	private String operator;
	//模块
	private String module;
	//方法
	private String method;
	//ip
	private String ip;
	//url
	private String url;
	//描述
	private String desc;
	//状态，0成功，1失败，2异常
	private Integer state;
	//操作开始时间
	private Date actionStartDate;
	//操作结束时间
	private Date actionEndDate;
	//日志创建时间
	private Date createdDate;
}
