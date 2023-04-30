package com;

public class Test1 
{
	
	public static String authenticate() 
	{

		String arr[] = {"adii","pavan","sachin","nikhil"};
		
		String name = "adii";
		
		for(String obj : arr)
		{
			if(obj == name)
			{
				return "pass";
			}
		}
		return "fail";
	}
	
	public static void main(String[] args) 
	{
		String sdsd = Test1.authenticate();
		System.out.println(sdsd);
		System.out.println("this is my program");
	}
}
