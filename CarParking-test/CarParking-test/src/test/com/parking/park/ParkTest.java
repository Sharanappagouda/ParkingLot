package test.com.parking.park;

import main.com.parking.exceptions.CoordinatesoutofRange;
import main.com.parking.validations.Validations;
import main.com.parking.park.Park;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParkTest {

	private int positionX;
	private int positionY;
	private int length;
	private int breadth;
	private int newPosition;
	private String movement=null;
	private String orientation=null;
	private int expectedResult;
	private Park Park ;
	
	   @Before
	   public void initialize() {
		   Park = new Park();
	   }

		public ParkTest(int positionX,int positionY,String orientation, String movement,int length,int breadth,int newPosition,int expectedResult) {
			this.positionX=positionX;
			this.positionY=positionY;
			this.length=length;
			this.breadth=breadth;
			this.movement=movement;
			this.newPosition=newPosition;
			this.orientation=orientation;
			this.expectedResult=expectedResult;
		}
	

		@Parameterized.Parameters
		  public static Collection coordinates() {
		      return Arrays.asList(new Object[][] {
		         { 1,1,"north","forward",2,2,1,1},
		         { 4,6,"south","backward",8,9,2,6},
		         { 4,3,"west","backward",8,9,5,-1}
		      });
		   }
		@Test(expected = CoordinatesoutofRange.class)
		   public void testcanFitInSlot() throws CoordinatesoutofRange {
			   System.out.println("Parameters are : " +positionX+","+positionY+","+length+","+breadth
					   				+","+orientation+","+movement+","+newPosition);
			      assertEquals(expectedResult, 
			    		  Park.canFitInSlot(positionX, positionY, orientation, movement, length, breadth, newPosition));
			   }

}
