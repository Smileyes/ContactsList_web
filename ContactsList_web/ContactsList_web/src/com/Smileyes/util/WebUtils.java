package com.Smileyes.util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	public static <T> T copyToBean(ServletRequest request, Class<T> clazz) {
		try {
			T t = clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (InstantiationException | IllegalAccessException
				| InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
