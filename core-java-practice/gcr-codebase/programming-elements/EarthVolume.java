// Write a Program to compute the volume of Earth in km^3 and miles^3

class EarthVolume {
    public static void main(String[] args) {
	    double PI = 3.14;
		int earthRadiusKm = 6378;
		double earthVolumeInKilometers = (4.0/3.0) * PI * earthRadiusKm * earthRadiusKm * earthRadiusKm;
		double earthRadiusMiles = earthRadiusKm * 0.621371;
		double earthVolumeInMiles = (4.0/3.0) * PI * earthRadiusMiles * earthRadiusMiles * earthRadiusMiles;
		
		System.out.println("The volume of earth in cubic kilometers is " + earthVolumeInKilometers + " and cubic miles is " + earthVolumeInMiles);
	}
}