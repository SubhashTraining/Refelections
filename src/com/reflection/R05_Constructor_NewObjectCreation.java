package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.reflection.R04_Constructor.Address;
import com.reflection.R04_Constructor.Person;

public class R05_Constructor_NewObjectCreation {
	
	
	

	
	public static void main(String args[]) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//Even if you dont pass any args value still works.To call the no argument constructor just pass no args
		Person p = (Person) createObject(Person.class);
		System.out.println(p);
		
		Person p1 = createObject2(Person.class,"Subhash",12444);
		System.out.println(p1);
		
		Address a1 = createObject2(Address.class,"Casa Grand Urbaone, Chennai");
		System.out.println(a1);
		
		String s1 = createObject3(String.class,"Reflection- Parameter Types Check");
		System.out.println(s1);
	}	
	
	//Factory Method that creates a new Object for any class by specifying the arguments
	
	public static Object createObject(Class<?> clazz,Object...args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		for(Constructor<?> constructor: clazz.getDeclaredConstructors()) {
		 if(constructor.getParameterTypes().length==args.length) {
			return constructor.newInstance(args);//if the variable args is null still it calls the default constructor or no args const
		 }
		
		}
		System.out.println("An appropriate constructor was not found");
		return null;
	}
	
	// in the above we are just returning an object , and the type casting in the main method to Person Class
	// we can avoid that by using generics. We are receiving a class of Type T and we are returning an object of Class of type T
	
	
	public static <T> T createObject2(Class<T> clazz, Object...args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		for(Constructor<?> constructor: clazz.getDeclaredConstructors()) {
			if(constructor.getParameterTypes().length==args.length)
			{
				return (T) constructor.newInstance(args);
			}
		}
		System.out.println("An appropriate constuctor was not found");
		return null;
	}
	
	
	
	public static <T> T createObject3(Class<T> clazz, Object...args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<?>[] parameterTypes = Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
		
		Constructor<?>  constructor = clazz.getDeclaredConstructor(parameterTypes);
		
		return (T)constructor.newInstance(args);
		
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



