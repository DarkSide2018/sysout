package ru.sysout.service;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName) {

        return bean;
    }
}
