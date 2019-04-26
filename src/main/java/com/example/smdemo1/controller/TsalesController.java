package com.example.smdemo1.controller;

import javax.annotation.Resource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

import com.example.smdemo1.annoation.OperLog;
import com.example.smdemo1.dto.response.BaseResponseDTO;
import com.example.smdemo1.model.Tsales;
import com.example.smdemo1.service.TsalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xp-dc
 * @date 2018/12/25
 */

@RestController
@Api(tags = "TsalesController", description = "TsalesController测试")
public class TsalesController {

	@Resource
	private TsalesService tsalesService;

	@OperLog(module = "zero", method = "/sales")
	@GetMapping("/sales")
	@ApiOperation("查询所有sales")
	public BaseResponseDTO<List<Tsales>> sales(){
		List<Tsales> sales = tsalesService.listAll();
		if(sales.size() > 0){
			try{
				Method method = this.getClass().getMethod("sales", null);
				OperLog operLog = method.getAnnotation(OperLog.class);
				if(operLog ==null) throw new RuntimeException("please add Operlog");
				InvocationHandler invocationHandler = Proxy.getInvocationHandler(operLog);
				Field value = invocationHandler.getClass().getDeclaredField("memberValues");
				value.setAccessible(true);
				Map<String, Object> memberValues = (Map<String, Object>)value.get(invocationHandler);
				String val = (String) memberValues.get("module");
				System.out.println("module old value is :"+val);
				val = "sales";
				memberValues.put("module", val);
				System.out.println("module new value is :"+operLog.module());
			}catch(NoSuchMethodException e){
				e.printStackTrace();
				System.out.println("getMethod error;");
			}catch(NoSuchFieldException e){
				e.printStackTrace();
				System.out.println("getDeclaredField error");
			}catch(IllegalAccessException e){
				e.printStackTrace();
				System.out.println("get error");
			}
		}
		return BaseResponseDTO.build(sales);
	}
}
