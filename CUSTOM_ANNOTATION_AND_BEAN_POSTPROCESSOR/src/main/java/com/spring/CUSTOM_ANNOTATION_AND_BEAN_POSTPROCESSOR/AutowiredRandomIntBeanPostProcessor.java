package com.spring.CUSTOM_ANNOTATION_AND_BEAN_POSTPROCESSOR;

import lombok.SneakyThrows;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Lazy(false)
public class AutowiredRandomIntBeanPostProcessor implements BeanPostProcessor {

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutowiredRandomInt.class)) {
                AutowiredRandomInt annotation = field.getAnnotation(AutowiredRandomInt.class);
                int random = ThreadLocalRandom.current().nextInt(annotation.min(), annotation.max());
                field.setAccessible(true);
                field.set(bean, random);
                //field.setInt(bean, random);
            }
        }
        return bean;
    }
}
