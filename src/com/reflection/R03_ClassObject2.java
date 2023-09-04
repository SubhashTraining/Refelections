package com.reflection;

import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class R03_ClassObject2 {


	
	
	
	public static void main(String args[]) throws ClassNotFoundException {
		
		
		//Anonymous CLass - Has no name
		drawable drawing2 = new drawable() {

			@Override
			public int getNumberOfCorners() {
				// TODO Auto-generated method stub
				return 7;
			}
			
		};
		
		printClassInfo(Collection.class, int[][].class,boolean.class,color.class,drawing2.getClass());
		
		
	}
	
	private static void printClassInfo(Class<?>...classes ) {
		
		for(Class<?> clazz :classes) {
			
			System.out.println(String.format("Class name: %s - PackageName %s", clazz.getSimpleName(),clazz.getPackage()));
			
			
			Class<?>[] implementationClasses = clazz.getInterfaces();
			for(Class<?> interfaces : implementationClasses) {
				System.out.println(String.format("Class %s implements %s class", 
						clazz.getSimpleName(),interfaces.getSimpleName()));
			}
 			
			System.out.println("Is Array: "+clazz.isArray());
			System.out.println("Is Interface: "+clazz.isInterface());
			System.out.println("Is Enum: "+clazz.isEnum());
			System.out.println("Is Primitive: "+clazz.isPrimitive());
			System.out.println("Is AnonymousClass: "+clazz.isAnonymousClass());
			
			System.out.println("\n\n");
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

