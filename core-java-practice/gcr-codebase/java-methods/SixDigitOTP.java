public class SixDigitOTP {
	
	// Method to generate random otps 
	public static int[] generateOTP(int size) {
		int[] otps = new int[size];
		
		for (int i = 0; i < size; i++)  {
			otps[i] = (int)((Math.random() * 900000) + 100000);
		}
		return otps;
	}
	
	// Method to check uniqueness of all otps
	public static boolean checkUniqueness(int size) {
		int[] otps = generateOTP(size);
		
		for (int i = 0; i < size; i++) {
			boolean isUnique = true;
			
			for (int j = 0; j < i; j++) {
				if (otps[i] == otps[j]) {
					return false;
					
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int size = 10;
		
		// Method call
		int[] otps = generateOTP(size);
		boolean isUnique = checkUniqueness(size);
		
		// Display OTPs and Uniqueness status
		System.out.print("OTPs are: [ ");
		for (int otp : otps) {
			System.out.print(otp + " ");
		}
		System.out.println("]");
		
		if (isUnique) {
			System.out.println("All OTPs are unique.");
		} else {
			System.out.println("All OTPs are not unique.");
		}
	}
}