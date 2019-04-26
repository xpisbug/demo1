package com.example.smdemo1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xp-dc
 * @date 2019/1/7
 */
@Target({ElementType.FIELD}) // 设置作用域为字段
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	String value(); //表的字段名
}
