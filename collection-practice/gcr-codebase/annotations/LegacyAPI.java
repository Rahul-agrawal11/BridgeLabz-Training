package annotations;

public class LegacyAPI {
	
	// @deprecated This method is obsolete.
	@Deprecated
	public void oldFeature() {
		System.out.println("Deprecatedtest oldFeature()");
	}
	
	public void newFeature() {
		System.out.println("This is new feature method.");
	}

	public static void main(String[] args) {
		LegacyAPI api = new LegacyAPI();
		// This will trigger a deprecation warning in IDEs and compilers
		api.oldFeature();
		api.newFeature();
	}
}
