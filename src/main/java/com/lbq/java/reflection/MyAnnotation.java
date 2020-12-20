package com.lbq.java.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
	java.lang.annotation.ElementType.TYPE,
	java.lang.annotation.ElementType.METHOD,
	java.lang.annotation.ElementType.PARAMETER,
	java.lang.annotation.ElementType.CONSTRUCTOR,
	java.lang.annotation.ElementType.LOCAL_VARIABLE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

	String value() default "hello";
}
