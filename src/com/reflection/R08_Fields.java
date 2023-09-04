package com.reflection;

import java.lang.reflect.Field;

/*
 	Class.getDeclaredFields () - to get all the fields including public and non public regardless of access
 		modifiers.Excludes inherited field
 	Class.getFields() - to get all the public fields including inherited fields
 	
 	if you know the field name:
 	Class.getDeclaredField(FieldName)
 	NoSuchFieldException
 	
 	Java compiler generate Synthetic field for internal usable and not visible to the user. you can check if 
 	a field is synthetic using isSynthetic method
 	
 	We can get the field value of an instance by Field.getValue(Instance)
 	
 	When i was accessing the private field value field.get(instace)
 	got error Illegal Access Exception cannot access private member variable 
 	so made field.setAccessible(true)
 	
 	if the field is a static field you can get the value of the field without passing the instance 
 	of it as Static fields are class fields and the instance will be ignored. You can also pass null
 */

public class R08_Fields {
	
	public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
	
		getDeclaredFields(Movie.class);
		getFields(Movie.class);
		getFields(Category.class);
		
		getFieldValues(Movie.class, new Movie("Jailer", 2023, true, Category.ACTION, 180));
		
		
		System.out.println("\n\n**********************");
		Field staticField =  Movie.class.getDeclaredField("MINIMUM_PRICE");
		System.out.println(String.format("The value of the static Field MINIMUM_PRICE is:%s", staticField.get(null)));
		
	}

	private static void getDeclaredFields(Class<?> clazz) {
		
		for(Field field : clazz.getDeclaredFields()) {
			
			System.out.println(String.format("Filed Name:%s and type: %s", field.getName(), field.getType().getName()));
		}
		
		
	}
	
	
	private static void getFields(Class<?> clazz) {
		
		for (Field field: clazz.getFields()) {
			
			System.out.println(String.format("Field Name:%s and type: %s" ,field.getName(),field.getType().getName()));
		}
		
	}
	
	//Generic method and Generic class 
	private static <T> void getFieldValues(Class<? extends T> clazz, T instance) throws IllegalArgumentException, IllegalAccessException {
	
		for(Field field : clazz.getDeclaredFields()) {
			
			field.setAccessible(true);
			System.out.println(String.format("Filed Name:%s and type: %s", field.getName(), field.getType().getName()));
			
			System .out.println(String.format("The value of the field is:%s",field.get(instance)));
			
		}
		
		
	}
	
	

}

class Movie extends product{
	
	public static final double MINIMUM_PRICE=10.00;

	public boolean isReleased;
	public Category category;
	private double actualPrice ;
	
	
	

	public Movie(String name, int year, boolean isReleased, Category category, double price) {
		super(name, year);
		// TODO Auto-generated constructor stub
		this.category= category;
		this.actualPrice= price;
		this.isReleased= isReleased;
		
	}
	
	
}

class product
{
	public String name;
	public int year;
	protected double actualprice;
	
	public product(String name, int year) {
		this.name=name;
		this.year= year;
		
	}
}

  enum Category{
	ADVENTURE,
	ACTION,
	COMEDY,
	CRIME;
}