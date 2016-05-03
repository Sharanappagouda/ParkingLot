package main.com.parking.display;

import main.com.parking.cars.Car;

public class DisplayCarPosition {

	public void displayCarPosition(Car Car){
		System.out.println("CAR COORDINATES are as below:");
		System.out.println("X coordinate of car is:"+Car.getPositionX());
		System.out.println("Y coordinate of car is:"+Car.getPositionY());
		System.out.println("Orientation  of car is:"+Car.getOrientation());
	}
}
