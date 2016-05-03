package main.com.parking.main;

		// TODO Auto-generated method stub
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.com.parking.cars.Car;
import main.com.parking.display.DisplayCarPosition;
import main.com.parking.exceptions.CoordinatesoutofRange;
import main.com.parking.exceptions.MovementException;
import main.com.parking.exceptions.OrientationException;
import main.com.parking.park.Park;
import main.com.parking.validations.Validations;



		public class mainPark {
		public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Validations Validations = new Validations();
		DisplayCarPosition DisplayCarPosition = new DisplayCarPosition();
		System.out.println("Enter current cordinates of parking lot in x and y format (comma seperated):");
		String str=null;
		
		try {
			str = br.readLine();
			String[] check = str.split(",");
			int length = Integer.parseInt(check[0]);
			int breadth= Integer.parseInt(check[1]);
			check = null;
			System.out.println("Enter coordinates to place the car in x and y format (comma seperated):");
			str= br.readLine();
			check = str.split(",");
			int positionX = Integer.parseInt(check[0]);
			int positionY= Integer.parseInt(check[1]);	
			check = null;
			Validations.coordinateValidate(positionX, positionY, length, breadth);

			System.out.println("Enter direction of orientation of car(east,west,north or south):");
			str= br.readLine();
			String orientation = str;
			Validations.orientationValidate(orientation);
			Car car = new Car(positionX,positionY,orientation);
			DisplayCarPosition.displayCarPosition(car);
			System.out.println("Enter direction of movement of car(forward or Backward):");
			str= br.readLine();
			String movement = str;
			Validations.movementValidate(movement);
			
			System.out.println("Enter number of units to move:");
			str= br.readLine();
			int newPosition = Integer.parseInt(str);
			Park Park = new Park();
			int newAxis = Park.canFitInSlot(positionX, positionY, orientation, movement, length, breadth, newPosition);

			if(orientation.equalsIgnoreCase("north")|| orientation.equalsIgnoreCase("south")){
				car.setPositionY(newAxis);
				DisplayCarPosition.displayCarPosition(car);
			}else if(orientation.equalsIgnoreCase("east")|| orientation.equalsIgnoreCase("west")){
				car.setPositionX(newAxis);
				DisplayCarPosition.displayCarPosition(car);
			}
		
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoordinatesoutofRange e) {
			System.out.println("Sorry, you entered out of range value:" + e.getcoordinate());
			e.printStackTrace();
		} catch (OrientationException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry, you entered wrong orientation:" + e.getorientation());
			e.printStackTrace();
		} catch (MovementException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry, you entered wrong direction of movement:" + e.getmovement());
			e.printStackTrace();
		}
	}
}

