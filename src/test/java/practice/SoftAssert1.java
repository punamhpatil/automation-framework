package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 {
	
@Test
	public void Sample()
	{
		SoftAssert sa = new SoftAssert();
		String a = "Hi";
		
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		
		sa.assertEquals(0, 1);
		sa.assertTrue(a.contains("i"));
		
		System.out.println("step4");
		System.out.println("step5");
		System.out.println("step6");
		
		sa.assertAll();
		
		
	}
}
