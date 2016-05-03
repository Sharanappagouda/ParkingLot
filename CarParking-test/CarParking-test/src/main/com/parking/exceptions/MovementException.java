package main.com.parking.exceptions;

@SuppressWarnings("serial")
public class MovementException extends Exception {

	   private String movement;
	   public MovementException(String movement)
	   {
	      this.movement = movement;
	   } 
	   public String getmovement()
	   {
	      return movement;
	   }
}
