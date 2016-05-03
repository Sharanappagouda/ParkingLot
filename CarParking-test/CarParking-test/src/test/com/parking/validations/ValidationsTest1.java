package test.com.parking.validations;

import main.com.parking.exceptions.CoordinatesoutofRange;
import main.com.parking.validations.Validations;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ValidationsTest1 {

	private int positionX;
	private int positionY;
	private int length;
	private int breadth;
	private Validations Validations;

	   @Before
	   public void initialize() {
		   Validations = new Validations();
	   }
	
	public ValidationsTest1(int positionX,int positionY,int length,int breadth) {
		this.positionX=positionX;
		this.positionY=positionY;
		this.length=length;
		this.breadth=breadth;
	}
	   
	@Parameterized.Parameters
	  public static Collection coordinates() {
	      return Arrays.asList(new Object[][] {
	         { 10,10,2,2},
	         { 1,1,2,2},
	         { 2,2,10,10},
	         { 3,4,5,5}
	      });
	   }

	@Test(expected = CoordinatesoutofRange.class)
	   public void testcoordinateValidate() throws CoordinatesoutofRange {
	      System.out.println("Parameters are : " +positionX+","+positionY+","+length+","+breadth);
	    		  Validations.coordinateValidate(positionX,positionY,length,breadth);
	   }	
}	

