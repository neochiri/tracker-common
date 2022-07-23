package com.tlc.tracker.exception;

import com.tlc.tracker.security.SecurityConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({ GlobalExceptionHandler.class })
public @interface TrackerException {
}
