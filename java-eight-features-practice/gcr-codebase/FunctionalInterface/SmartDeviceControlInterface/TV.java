package FunctionalInterface.SmartDeviceControlInterface;

public class TV implements DeviceController{
	
	@Override
	public void turnOn() {
		System.out.println("TV on.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV off.");
	}
}
