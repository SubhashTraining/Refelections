

/*
 	Constructor of a class is represented by an instance of Constructor<?> class
 	Constructor object contains all the information about the constructor including - no or parameters and types of parameter 
 	
 	Class.getDeclaredConstructor - all public and non public constructors
 	Class.getConstructor - returns only the public constructors
 	
 	if there are no constructors declared explicitly getDeclaredConstructor would return the default constructor
 */

package com.reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class R04_Constructor {
	
	
	
	public static void main(String args[]) throws NoSuchMethodException, SecurityException {
		
		
		
	printConstructorData(Person.class);	
	printConstructorData(Address.class);		
	}	
	
	public static void printConstructorData(Class<?> clazz) {
		
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		System.out.println(String.format("The class %s has %d declared constructors",clazz.getSimpleName(),constructors.length));
		for(Constructor<?> currentConstructors: constructors) {
			
			Class<?>[] parameters = currentConstructors.getParameterTypes();
			
			List<String> parameterTypes= Arrays.stream(parameters).map(Class::getSimpleName).collect(Collectors.toList());
			System.out.println(parameterTypes);
			
		}
		
	}
	
	public static class Person{
		private String name;
		private Address Address;
		private int phoneNo;
		
		

		public Person() {
			this.name="anonymous";
			this.Address= new Address("Making Street");
			this.phoneNo=25656;
		}
		
		public Person(String name,int PhoneNo) {
			this.name=name;
			this.Address= new Address("Making Street");
			this.phoneNo=PhoneNo;
		}
		
		public Person(String name,String AddresssLine1,int PhoneNo) {
			this.name=name;
			this.Address= new Address(AddresssLine1);
			this.phoneNo=PhoneNo;
		}
		
		
		@Override
		public String toString() {
			return "Person [name=" + name + ", Address=" + Address + ", phoneNo=" + phoneNo + "]";
		}
	}

	public static class Address{
		String AddressLine1;
		
		
		public Address(String AddressLine1 )
		{
			this.AddressLine1=AddressLine1;
			
		}

		public String getAddressLine1() {
			return AddressLine1;
		}

		@Override
		public String toString() {
			return "Address [AddressLine1=" + AddressLine1 + "]";
		}

			
	}
	
	
}
