package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@MobileTest")
	public void beforeValidation()
	{
		System.out.println(" Before : Mobile before Hook!!");
	}
	@After("@MobileTest")
	public void afterValidaton()
	{
		System.out.println("After : Mobile after hook!! ");
	}
	
	@Before("@RegressionTest")
	public void BeforeValidation()
	{
		System.out.println(" Before : Regression before Hook!!");
	}
	@After("@RegressionTest")
	public void AfterValidaton()
	{
		System.out.println("After : Regression after hook!! ");
	}
}
