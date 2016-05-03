package main.com.parking.exceptions;

@SuppressWarnings("serial")
public class CoordinatesoutofRange extends Exception {

	   private int coordinate;
	   public CoordinatesoutofRange(int coordinate)
	   {
	      this.coordinate = coordinate;
	   } 
	   public int getcoordinate()
	   {
	      return coordinate;
	   }
}
