package com.reflection;
/*
 	Assume if you want to instantiate a object using reflection. And if that parameters of the consturctor is an
 	object whose constructor has multiple parameters , we need to resolve the dependency injection
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
public class R07_Constructor_DependencyInjection {
	
	public static void main(String agrs[]) {
		
	}
	
	//Factory method to implement dependency injection
	
	@SuppressWarnings("unchecked")
	private <T> T createObjectsRecursively(Class<T> clazz ) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		List<Object> parametersAsObjects = new ArrayList<>();
		
		Constructor<?> constructor = getFirstConstructor(clazz);
		
		for(Class<?> parameterType: constructor.getParameterTypes()) {
			
			Object object = createObjectsRecursively(parameterType);
			parametersAsObjects.add(object);
			
		}
		
		constructor.setAccessible(true);
		return (T) constructor.newInstance(parametersAsObjects.toArray());
		
	}
	
	private static Constructor<?> getFirstConstructor(Class<?> clazz){
		
		Constructor<?>[] constructors= clazz.getDeclaredConstructors();
		
		if(constructors.length==0) {
			throw new IllegalStateException
			(String.format("No constructor has been found for the class %s", clazz.getSimpleName()));}
	
		return constructors[0];
	}

}
