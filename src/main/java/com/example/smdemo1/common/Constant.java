package com.example.smdemo1.common;

/**
 * @author xp-dc
 * @date 2019/4/25
 */
public interface Constant {

	//文件编码
	interface Encode {
		String UTF_8 = "UTF-8";
		String GBK = "GBK";
		String ISO_8859_1 = "ISO_8859_1";
		String DEFAULT = UTF_8;
	}


	//响应状态码
	interface ResponseCode {

		/**
		 * 处理成功
		 */
		int SUCCESS = 0;

		/**
		 * 处理失败
		 */
		int FIAL = -1;
	}
}
