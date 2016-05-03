package main.com.parking.exceptions;

@SuppressWarnings("serial")
public class OrientationException extends Exception {

	   private String orientation;
	   public OrientationException(String orientation)
	   {
	      this.orientation = orientation;
	   } 
	   public String getorientation()
	   {
	      return orientation;
	   }
}
