package com.example.smdemo1.dto.response;

import java.io.Serializable;

import com.example.smdemo1.common.Constant;
import com.example.smdemo1.util.ResponseCodeUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
@Setter
@Getter
@ToString
public class BaseResponseDTO<T> implements Serializable {
	private static final long serialVersionUID = -4049706808413497765L;

	private int code;

	private String message;

	private T data;

	private BaseResponseDTO(){}

	private BaseResponseDTO(T data){
		this.data = data;
	}
	private BaseResponseDTO(T data, int code, String message){
		this.data = data;
		this.code = code;
		this.message = message;
	}

	/**
	 * 构建通用响应对象
	 * @param data
	 * @return
	 */
	public static <T> BaseResponseDTO<T> build(T data){
		int code = Constant.ResponseCode.SUCCESS;
		String message = ResponseCodeUtil.getMessage(code);
		return new BaseResponseDTO<T>(data, code, message);
	}

	/**
	 * 构建通用响应对象
	 * @param data
	 * @param code
	 * @return
	 */
	public static <T> BaseResponseDTO<T> build(T data, int code){
		String message = ResponseCodeUtil.getMessage(code);
		return new BaseResponseDTO<T>(data, code, message);
	}

	/**
	 * 构建通用响应对象
	 * @param code
	 * @param message
	 * @return
	 */
	public static <T> BaseResponseDTO<T> build(int code, String message){
		return new BaseResponseDTO<T>(null, code, message);
	}

	/**
	 * 构建通用响应对象
	 * @param data
	 * @param code
	 * @param message
	 * @return
	 */
	public static <T> BaseResponseDTO<T> build(T data, int code, String message){
		return new BaseResponseDTO<T>(data, code, message);
	}

}
