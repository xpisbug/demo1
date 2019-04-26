package com.example.smdemo1.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import com.example.smdemo1.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Properties属性文件工具类
 * @author xp-dc
 * @date 2019/4/25
 */
@Slf4j
public final class PropertiesUtil {

	/**
	 * 加载Properties属性文件
	 * @param propFilePath 文件相对classpath的路径
	 * @param encode 文件编码
	 * @return
	 */
	public static Properties loadProperties(String propFilePath, String encode){
		if(StringUtils.isBlank(propFilePath)){
			return null;
		}

		Properties prop = null;
		InputStream in = null;
		try{
			in = PropertiesUtil.class.getResourceAsStream(propFilePath);
			prop = loadProperties(in, encode);
		}catch(Exception e){
			log.error("Loading properties - {}; exp:{}", propFilePath, e);
		}finally{
			if(in != null){
				try{
					in.close();
				}catch(IOException e){
				}
			}
		}
		return prop;
	}

	/**
	 * 加载Properties属性文件
	 * @param propFilePath 文件相对classpath的路径
	 * @return
	 */
	public static Properties loadProperties(String propFilePath) {
		if(StringUtils.isBlank(propFilePath)){
			return null;
		}

		return loadProperties(propFilePath, Constant.Encode.UTF_8);
	}

	/**
	 * 加载Properties属性文件
	 * @param in
	 * @param encode
	 * @return
	 */
	public static Properties loadProperties(InputStream in, String encode){
		if(in == null){
			return null;
		}

		if(StringUtils.isBlank(encode)){
			encode = Constant.Encode.DEFAULT;
		}

		Properties prop = new Properties();
		Reader reader = null;
		try{
			reader = new InputStreamReader(in, encode);
			prop.load(reader);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			log.error("Un-supported encode exp: {}", e);
		}catch(IOException e){
			e.printStackTrace();
			log.error("Reading inputStream exp: {}", e);
		}finally{
			prop = null;
			if(reader != null){
				try{
					reader.close();
				}catch(IOException e){
				}
			}
		}

		return prop;
	}
}
