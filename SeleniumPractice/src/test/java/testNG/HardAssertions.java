package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	void test() {
		//int x=10;
		//int y=50;
		/*
		if(x==y) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
		*/
		
		//Assert.assertEquals(x,y);
		//Assert.assertTrue(true);
		
		/*int a=10;
		int b=20;
		Assert.assertEquals(a>b,true,"a is not greater than b");*/
		
		String s1="abc";
		String s2="abc";
		
		//Assert.assertEquals(s1,21,"string are not equal");
		//
		Assert.assertNotEquals(s1, s2);
		
		if(true) {
			Assert.assertTrue(true);
		}else 
		{
			Assert.assertTrue(false);
		}
		
	}
}
