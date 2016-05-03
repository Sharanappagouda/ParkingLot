package test.com.parking.validations;

import main.com.parking.exceptions.CoordinatesoutofRange;
import main.com.parking.exceptions.OrientationException;
import main.com.parking.validations.Validations;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ValidationsTest3 {

	private String orientation=null;
	private Boolean expectedResult;
	private Validations Validations;

	   @Before
	   public void initialize() {
		   Validations = new Validations();
	   }
	
	public ValidationsTest3(String orientation) {
		this.orientation=orientation;
	}
	   
	@Parameterized.Parameters
	  public static Collection coordinates() {
	      return Arrays.asList(new Object[][] {
	         { "north"},
	         {"south"},
	         { "none"},
	         { "false"}
	      });
	   }

	@Test(expected = OrientationException.class)
	   public void testorientationValidate() throws OrientationException {
	      System.out.println("orientation is : " +orientation);
	    		  Validations.orientationValidate(orientation);
	   }	
}	

