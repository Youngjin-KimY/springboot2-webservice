package com.ebay.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)

public @interface LoginUser {
}