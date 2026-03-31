package FunctionalInterface.SmartDeviceControlInterface;

public class AC implements DeviceController{
	
	@Override
	public void turnOn() {
		System.out.println("AC on.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("AC off.");
	}
}