package com.mitocode.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MitoCodeBeanPostProcesor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String nombreBean) throws BeansException{
		System.out.println("Después de la inicialización: " + nombreBean);
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String nombreBean) throws BeansException{
		System.out.println("Antes de la inicialización: " + nombreBean);
		return bean;
	}
}
