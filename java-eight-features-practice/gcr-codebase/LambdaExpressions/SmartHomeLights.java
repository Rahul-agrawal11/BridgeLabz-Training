package LambdaExpressions;

@FunctionalInterface
interface LightAction {
	void activate();
}

public class SmartHomeLights {

	public static void main(String[] args) {
		LightAction motionTrigger = () -> System.out.println("Motion detected -> Turn ON hallway lights at 100% brightness");
		LightAction nightTrigger = () -> System.out.println("Night time -> Turn ON warm lights at 30% brightness");
		LightAction voiceTrigger = () -> System.out.println("Voice command -> Activate PARTY mode lights");
		
		motionTrigger.activate();
		nightTrigger.activate();
		voiceTrigger.activate();
	}

}
