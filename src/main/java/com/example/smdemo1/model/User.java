package com.example.smdemo1.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


//@Component表示当前类是一个Java Bean
//@ConfigurationProperties(value = "user")表示获取前缀为user的配置信息
//@Component
//@ConfigurationProperties(value = "user")
//@PropertySource(value = "classpath:/application.properties")
public class User {
	private Integer id;
	//@Value("${user.name}")
	private String name;
	private Integer age;
	//@Value("${user.desc}")
	private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", desc='" + desc + '\'' +
				'}';
	}
}
