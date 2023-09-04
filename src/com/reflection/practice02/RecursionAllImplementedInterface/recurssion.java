package com.reflection.practice02.RecursionAllImplementedInterface;

import java.util.*;

public class recurssion {

	public static void main(String args[]) {
		
		
		System.out.println(findAllImplemenetedInterface(LinkedList.class));
		
	}
	
	public static Set<Class<?>> findAllImplemenetedInterface(Class<?> input){
		
		Set<Class<?>> implementedInterfaces = new HashSet<>();
		
		Class<?>[] inputInterfaces = input.getInterfaces();
		
		for(Class<?> currentInterface: inputInterfaces) {
			implementedInterfaces.add(currentInterface);
			
			implementedInterfaces.addAll(findAllImplemenetedInterface(currentInterface));
			
			
		}
		
		return implementedInterfaces;
 		
	}
	
}
