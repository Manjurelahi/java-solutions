/*
JDK8+ Code Test 
Consider below data for Vehicle Parking System.
Vehicle Parking: Number Plate, Start Time, End Time
1. Find vehicle which has maximum parking time
2. Calculate total parking time for all vehicles
*/

import java.util.*;
import java.util.stream.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Vehicle {
	private String numberPlate;
	private String startTime;
	private String endTime;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
	
	public Vehicle(String numberPlate, String startTime, String endTime) {
		this.numberPlate = numberPlate;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getNumberPlate() {
		return numberPlate;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public LocalTime getStartLocalTime() {
		return LocalTime.parse(getStartTime(), dtf);
	}
	
	public LocalTime getEndLocalTime() {
		return LocalTime.parse(getEndTime(), dtf);
	}
	
	public long getParkingTimeInMinutes() {
		return ChronoUnit.MINUTES.between(getStartLocalTime(), getEndLocalTime());
	}
	
	@Override
	public String toString() {
		return "Vehicle Number Plate: "+getNumberPlate()+", Start Time: "+getStartTime()+", End Time: "+getEndTime();
	}
	
}

public class VehicleParkingTime {
	
	public static Vehicle findMaxParkedVehicle(List<Vehicle> vehicleList) {
		return vehicleList.stream().max(Comparator.comparing(Vehicle::getParkingTimeInMinutes)).get();
	}
	
	public static double calculateTotalParkingTime(List<Vehicle> vehicleList) {
		return ((double)(vehicleList.stream().mapToLong(Vehicle::getParkingTimeInMinutes).sum()))/60.00d;
	}
	
	public static void main(String[] args) {
		List<Vehicle> vehicleList = List.of(
			new Vehicle("KA03", "09:45 AM", "12:00 PM"), // 02:15
			new Vehicle("GJ05", "10:15 AM", "01:00 PM"), // 02:45
			new Vehicle("UP07", "12:00 PM", "12:45 PM"), // 00:45
			new Vehicle("MH01", "10:00 AM", "10:00 PM"), // 12:00
			new Vehicle("WB08", "12:00 AM", "02:15 AM")  // 02:15						
		);
		System.out.println("Max Parked Vehicle- "+findMaxParkedVehicle(vehicleList));
		System.out.println("All Vehicles Parking Time: "+String.format("%.2f", calculateTotalParkingTime(vehicleList)) + " Hours");		
	}
}

/*
Output
Max Parked Vehicle- Vehicle Number Plate: MH01, Start Time: 10:00 AM, End Time: 10:00 PM
All Vehicles Parking Time: 20.00 Hours
*/