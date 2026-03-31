// Super Class 
class Device {
	String deviceId;
	String status;
	
	Device(String deviceId, String status) {
		this.deviceId = deviceId;
		this.status = status;
	}
}

// Subclass of Device
class Thermostat extends Device {
	String temperatureSetting;
	
	Thermostat(String deviceId, String status, String temperatureSetting) {
		super(deviceId, status);
		this.temperatureSetting = temperatureSetting;
	}
	
	void displayStatus() {
		System.out.println("Device Id: " + deviceId);
		System.out.println("Status: " + status);
		System.out.println("Current Setting: " + temperatureSetting);
	}
}

// Main Class 
public class SmartHomeDevices {
	public static void main(String[] args) {
	Thermostat thermostat = new Thermostat("D001", "Active", "High");
	thermostat.displayStatus();
	}
}