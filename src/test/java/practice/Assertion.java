package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
	@Test
	

	public void Sample()
	{
		 
		String a = "Hi";
		
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		
		Assert.assertTrue(a.contains("i"));
		Assert.assertEquals(1, 1);
		
		System.out.println("step4");
		System.out.println("step5");
		System.out.println("step6");
		
		
		
	}
}
