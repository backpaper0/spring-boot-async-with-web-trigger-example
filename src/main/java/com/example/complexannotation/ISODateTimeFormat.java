package com.example.complexannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Retention(RetentionPolicy.RUNTIME)
@DateTimeFormat(iso = ISO.DATE_TIME)
public @interface ISODateTimeFormat {
}
