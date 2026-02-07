package scenario.OceanFleet;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VesselUtil vesselUtil = new VesselUtil();
		System.out.println("Enter the number of vessels to be added");
		int num = sc.nextInt();
		sc.nextLine();
		String[] vessels = new String[num];
		
		for (int i = 0; i < num; i++) {
			vessels[i] = sc.nextLine();
			String[] data = vessels[i].split(":");
			vesselUtil.addVesselPerformance(new Vessel(data[0], data[1], Double.parseDouble(data[2]), data[3]));
		}
		
		System.out.println("Enter the Vessel Id to check speed: ");
		String vesselId = sc.nextLine();
		Vessel v = vesselUtil.getVesselById(vesselId);
		if (v == null) {
			System.out.println("Vessel Id "+ vesselId +" not found");
		} else {			
			System.out.println(v);
		}
		
		List<Vessel> vi = vesselUtil.getHighPerformanceVessels();
		for (Vessel ves : vi) {
			System.out.println(ves);
		}
		sc.close();
	}

}
