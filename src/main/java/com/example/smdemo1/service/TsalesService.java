package com.example.smdemo1.service;

import javax.annotation.Resource;

import java.util.List;

import com.example.smdemo1.dao.TsalesMapper;
import com.example.smdemo1.model.Tsales;
import org.springframework.stereotype.Service;

/**
 * @author xp-dc
 * @date 2018/12/25
 */
@Service
public class TsalesService {

	@Resource
	private TsalesMapper tsalesMapper;

	public List<Tsales> listAll(){
		return tsalesMapper.listAll();
	}


}
