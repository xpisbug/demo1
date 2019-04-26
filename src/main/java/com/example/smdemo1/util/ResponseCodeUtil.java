package com.example.smdemo1.util;

import java.util.Properties;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
public class ResponseCodeUtil {

	private static final String RESPONSE_MSG_PATH = "";
	private static Properties RESPONSE_MSG_PROP;

	static {
		RESPONSE_MSG_PROP = PropertiesUtil.loadProperties(RESPONSE_MSG_PATH);
	}

	/**
	 * 根据响应码获取响应提示信息
	 * @param code
	 * @return
	 */
	public static String getMessage(int code){
		return RESPONSE_MSG_PROP == null ? null : RESPONSE_MSG_PROP.getProperty(String.valueOf(code));
	}
}
