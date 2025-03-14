package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
//어노테이션이 생성될 수 있는 위치 지정.
//Paramaeter로 지정했으니 메소드의 파라미터로 선언된 객체에서 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
