package testng_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	@Test
	public void case1() {
		System.out.println("Hey ther!!!!");  //console
	}
	@Test
	public void case2() {
		Reporter.log("hyy prince and mayank!!!!"); //report
		Reporter.log("hyy prince and mayank!!!!",true); //report + console print
	}
}
