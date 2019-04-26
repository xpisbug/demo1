package com.example.smdemo1.dao;

import java.util.List;

import com.example.smdemo1.model.Tsales;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xp-dc
 * @date 2018/12/25
 */
@Mapper
public interface TsalesMapper {
	int insert();

	List<Tsales> listAll();
}
