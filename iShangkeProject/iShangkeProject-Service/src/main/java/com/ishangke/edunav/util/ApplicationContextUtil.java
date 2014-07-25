package com.ishangke.edunav.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    @Autowired
    private static ApplicationContext springContext;

    public static ApplicationContext getSpringContext() {
        return springContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.springContext = applicationContext;
    }

    public static Object getBean(String beanName) {
        return getSpringContext().getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getSpringContext().getBean(clazz);
    }
}
