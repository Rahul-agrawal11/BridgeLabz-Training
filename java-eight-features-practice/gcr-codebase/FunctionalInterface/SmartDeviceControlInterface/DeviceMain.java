package FunctionalInterface.SmartDeviceControlInterface;

public class DeviceMain {

	public static void main(String[] args) {
		
		// ------- TV Class Using DeviceController interface to on & off TV -------
		TV tv = new TV();
		tv.turnOn();
		tv.turnOff();
		System.out.println();
		
		// ------- AC Class Using DeviceController interface to on & off AC -------
		AC ac = new AC();
		ac.turnOn();
		ac.turnOff();
		System.out.println();
		
		// ------- Lights Class Using DeviceController interface to on & off Lights -------
		Lights lights = new Lights();
		lights.turnOn();
		lights.turnOff();
		System.out.println();
	}

}
