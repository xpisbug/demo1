package com.example.smdemo1.model;

import java.util.Date;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author xp-dc
 * @date 2018/12/25
 */
@Data
public class Tsales {
	@ApiParam("id")
	private Integer id;
	@ApiParam("日期")
	private Date date;
	@ApiParam("价格")
	private Integer cost;

}
