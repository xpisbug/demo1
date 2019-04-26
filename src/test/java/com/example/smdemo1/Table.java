package com.example.smdemo1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xp-dc
 * @date 2019/1/7
 */
@Target({ElementType.TYPE}) // 设置作用域为类接口
@Retention(RetentionPolicy.RUNTIME) // 设置生命周期为运行时
public @interface Table {
	String value(); // 表名
}
