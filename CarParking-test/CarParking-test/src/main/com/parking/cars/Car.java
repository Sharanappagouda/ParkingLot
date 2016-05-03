package main.com.parking.cars;
import main.com.parking.exceptions.*;

public class Car {

private int positionX;
private int positionY;
private String orientation;

public Car(int positionX, int positionY, String orientation){
	this.positionX = positionX;
	this.positionY = positionY;
	this.orientation =orientation;
}

public int getPositionX() {
	return positionX;
}
public void setPositionX(int positionX) {
	this.positionX = positionX;
}
public int getPositionY() {
	return positionY;
}
public void setPositionY(int positionY) {
	this.positionY = positionY;
}
public String getOrientation() {
	return orientation;
}
public void setOrientation(String orientation) {
	this.orientation = orientation;
}

public int canFitInSlot(int positionX, int positionY, String orientation, String movement,int length,int breadth, int newPosition) throws CoordinatesoutofRange{
	int newX=0;
	int newY=0;
	try{
		switch(orientation){
			case "east":	if(movement.equalsIgnoreCase("forward")){
								 if((positionX + newPosition)>= length)
									 throw new CoordinatesoutofRange(positionX + newPosition);
								 else
									 newX = positionX + newPosition;
							}else if(movement.equalsIgnoreCase("backward")){
								if((positionX - newPosition) <= 0)
									throw new CoordinatesoutofRange(positionX - newPosition);
								else
									newX = positionX - newPosition;
							}	
							break;
			case "south":	if(movement.equalsIgnoreCase("forward")){
								if((positionY - newPosition) <= 0)
									 throw new CoordinatesoutofRange(positionY - newPosition);
								else
									newY = positionY - newPosition;
							}else if(movement.equalsIgnoreCase("backward")){
								if((positionY + newPosition) >= breadth)
									throw new CoordinatesoutofRange(positionY + newPosition);
								else
									newY = positionY + newPosition;
							}	
							break;
			case "west":	if(movement.equalsIgnoreCase("forward")){
				 				if((positionX - newPosition)<= 0)
				 					throw new CoordinatesoutofRange(positionX - newPosition);			
								else
									newX = positionX - newPosition;
							}else if(movement.equalsIgnoreCase("backward")){
								if((positionX + newPosition) >= length)
									throw new CoordinatesoutofRange(positionX + newPosition);
								else
									newX = positionX + newPosition;
							}	
							break;
			case "north":	if(movement.equalsIgnoreCase("forward")){
								if((positionY + newPosition) >= breadth)
									throw new CoordinatesoutofRange(positionY + newPosition);
								else
									newY = positionY + newPosition;
							}else if(movement.equalsIgnoreCase("backward")){
								if((positionY - newPosition) <= 0)
									throw new CoordinatesoutofRange(positionY + newPosition);
								else
									newY = positionY - newPosition;
							}	
							break;

			default :		break;	
		}
		}catch (CoordinatesoutofRange e){
			throw e;
		}
//	System.out.println("can can be parked at the given coordinates");
	if(newX == 0){
		System.out.println("Car can be parked at new Y location");
	return newY;
	}else{
		System.out.println("Car can be parked at new X location");
	return newX;
	}
}
}
