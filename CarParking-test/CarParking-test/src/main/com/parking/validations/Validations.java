package main.com.parking.validations;

import main.com.parking.exceptions.CoordinatesoutofRange;
import main.com.parking.exceptions.MovementException;
import main.com.parking.exceptions.OrientationException;

public class Validations {

	public void coordinateValidate(int positionX,int positionY, int length, int breadth) throws CoordinatesoutofRange{
		try{
		if(positionX>length){			
			throw new CoordinatesoutofRange(positionX);
		}
		if(positionY>breadth){
			throw new CoordinatesoutofRange(positionY);
		}
		}catch (CoordinatesoutofRange e){
         throw e;
		}
	}

	public void orientationValidate(String orientation) throws OrientationException {
		if(orientation.equalsIgnoreCase("north")|| orientation.equalsIgnoreCase("south")||
				orientation.equalsIgnoreCase("east")|| orientation.equalsIgnoreCase("west")){
			return;			
		}else{
			throw new OrientationException(orientation);
		}
	}
	
	public void movementValidate(String movement) throws MovementException {
		if(movement.equalsIgnoreCase("forward")|| movement.equalsIgnoreCase("backward")){
			return;			
		}else{
			throw new MovementException(movement);
		}
	}
}
