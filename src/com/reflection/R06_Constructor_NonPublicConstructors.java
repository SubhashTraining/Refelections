package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;

class ServerConfiguration{
	
	private static ServerConfiguration serverConfigurationInstance;
	private  final InetSocketAddress serverAddress;
	private final String greetingMessgae;
	
	
	private ServerConfiguration(int port, String message) {
		this.serverAddress=new InetSocketAddress("local_host", port);
		this.greetingMessgae= message;
		if(serverConfigurationInstance==null)
		{
			//Watch Carefully
			serverConfigurationInstance=this;
		}
		
	}
	
	
	public static ServerConfiguration getServerConfigurationInstance() {
		return serverConfigurationInstance;
	}
	
	
	public static ServerConfiguration getInstance() {
		return serverConfigurationInstance;
	}
	
	public InetSocketAddress getServerAddress() {
		return serverAddress;
	}

	public String getGreetingMessgae() {
		return greetingMessgae;
	}
}



/*
 	 A package private constructor can be called by a class within the same package
 	 but not by a class outside the package
 	 
 	 A private constructor cannot be called by any other class unless you set the setAccessible(True) of the constructor object
 */



public class R06_Constructor_NonPublicConstructors {

	public static void main(String args[]) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		initConfiguration();
		ServerConfiguration serverConfiguration = ServerConfiguration.getInstance();
		System.out.println(serverConfiguration.getGreetingMessgae());
				
		
	}
	
	public static void initConfiguration() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Constructor<?> constructor = ServerConfiguration.class.getDeclaredConstructor(int.class,String.class); 
		constructor.setAccessible(true);
		constructor.newInstance(8080,"Welcome To reflection");
		
		
	}
	
}
