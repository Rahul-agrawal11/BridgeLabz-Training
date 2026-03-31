package FunctionalInterface.SmartDeviceControlInterface;

public class Lights implements DeviceController{
	
	@Override
	public void turnOn() {
		System.out.println("Lights on.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Lights off.");
	}
}