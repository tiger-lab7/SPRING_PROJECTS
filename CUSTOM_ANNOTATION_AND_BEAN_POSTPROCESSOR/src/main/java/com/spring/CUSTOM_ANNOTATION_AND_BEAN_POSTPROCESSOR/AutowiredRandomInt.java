package com.spring.CUSTOM_ANNOTATION_AND_BEAN_POSTPROCESSOR;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AutowiredRandomInt {
    int min();
    int max();
}
