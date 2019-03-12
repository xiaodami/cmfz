package com.baizhi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明注解使用时机
@Retention(RetentionPolicy.RUNTIME)
//声明注解使用位置
@Target(ElementType.FIELD)
public @interface Annotation {
	public String name();
}
