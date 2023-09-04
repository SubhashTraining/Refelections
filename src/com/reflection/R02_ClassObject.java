package com.reflection;

import java.util.*;

/*
 	Obtain class object Class<?> class in 3 ways
 	
 	1. if you have an object instance you can get Object.getClass()
 	2. Append .class with the class name.. Primitive class type can be obtained this way .. (int.class, boolean.class)
 	3. Class.forName(fully qualified class name) - can come handy by passing parameter
 	
 	
 	Class<?> means class object of any type. 

	In java CharSequence is a superclass of String
	Number is superclass of Integer
	
	But List<Number> is not a super class of List<Integer> - Inheritance is not permitted in generic
	However List<?> is the super Type of a list of any generic type
	
	 List<?> is a super type of any generic List Type T (List<T>). This type of generic is true for any generic type
	 including class
	 
	 Using Class<?> we can describe class object of any parameter type
 	
 	
 */


public class R02_ClassObject {
	
	
	
	
	
	
	public static void main(String args[]) throws ClassNotFoundException {
		
		
		Class<String> sClass = String.class;
		
		Map<String,Integer> map = new HashMap<>();
		Class<?> hashMapClass = map.getClass();
		
		
		Class<?> customClass = Class.forName("com.reflection.R02_ClassObject$drawing");
		//When you specify inner class you need to specify the outerclass $ Inner class name
		
		printClassInfo(sClass,hashMapClass,customClass);
		
		
		List<String> names = new ArrayList<>();
		Class<?> clazz = names.getClass();
		System.out.println(clazz.getTypeName());//java.util.ArrayList
		
		
	}
	
	private static void printClassInfo(Class<?>...classes ) {
		
		for(Class<?> clazz :classes) {
			
			System.out.println(String.format("Class name: %s - PackageName %s", clazz.getSimpleName(),clazz.getPackage()));
			
			
			Class<?>[] implementationClasses = clazz.getInterfaces();
			for(Class<?> interfaces : implementationClasses) {
				System.out.println(String.format("Class %s implements %s class", 
						clazz.getSimpleName(),interfaces.getSimpleName()));
			}
 			
			System.out.println();
			System.out.println();
		}
		
	
		
	}
	
	
	private interface drawable{
		
		int getNumberOfCorners();		
	}

	
	private static class drawing implements drawable{

		@Override
		public int getNumberOfCorners() {
			// TODO Auto-generated method stub
			return 5;
		}
		
	}
	
	private enum color{
		
		BLUE,
		ORANGE,
		RED
		
	}
}
