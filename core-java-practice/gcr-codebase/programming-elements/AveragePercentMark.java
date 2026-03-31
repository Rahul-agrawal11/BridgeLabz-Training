// Sam’s mark in Maths is 94, Physics is 95 and Chemistry is 96 out of 100. Find the average percent mark in PCM.

class AveragePercentMark {
    public static void main(String[] args) {
	    int mathMark = 94;
		int physicsMark = 95;
		int chemistryMark = 96;
		
		int totalObtainedMark = mathMark + physicsMark + chemistryMark;
		int totalMark = 300;
		
		double averagePercentMark = (totalObtainedMark * 100) / totalMark;
		
		System.out.println("Sam's average mark in PCM is " + averagePercentMark);
	}
}
