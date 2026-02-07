package scenario.OceanFleet;

import java.util.ArrayList;
import java.util.List;

public class VesselUtil {
	private List<Vessel> vesselList = new ArrayList<>();
	
	// Add Vessel details to the vesselList
	public void addVesselPerformance(Vessel vessel) {
		vesselList.add(vessel);
	}
	
	// Get Vessel details by id
	public Vessel getVesselById(String vesselId) {
		for (Vessel v : vesselList) {
			if (v.getVesselId().equals(vesselId)) {
				return v;
			}
		}
		return null;
	}
	
	// Get high performace vessel(s)
	public List<Vessel> getHighPerformanceVessels() {
		double maxSpeed = vesselList.stream()
	            .mapToDouble(Vessel::getAverageSpeed)
	            .max()
	            .orElse(0);
		return vesselList.stream()
	            .filter(v -> v.getAverageSpeed() == maxSpeed)
	            .toList();
	}
}
