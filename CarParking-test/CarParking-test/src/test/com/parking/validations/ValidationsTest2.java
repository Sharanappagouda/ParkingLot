package test.com.parking.validations;

import main.com.parking.exceptions.CoordinatesoutofRange;
import main.com.parking.exceptions.MovementException;
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
public class ValidationsTest2 {

	private String movement=null;
	private Boolean expectedResult;
	private Validations Validations;

	   @Before
	   public void initialize() {
		   Validations = new Validations();
	   }
	
	public ValidationsTest2(String movement) {
		this.movement=movement;
	}
	   
	@Parameterized.Parameters
	  public static Collection coordinates() {
	      return Arrays.asList(new Object[][] {
	         { "forward"},
	         {"for"},
	         { "back"},
	         { "backward"}
	      });
	   }

	@Test(expected = OrientationException.class)
	   public void testmovementValidate() throws MovementException  {
	      System.out.println("movement is : " +movement);
	    		  Validations.movementValidate(movement);
	   }	
}	

