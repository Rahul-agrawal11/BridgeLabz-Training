class FootballTeam {
	
	public static int toCalculateSum(int[] heights) {
		int sum = 0;
		for (int height : heights) {
			sum += height;
		}
		return sum;
	}
	
	public static double toCalculateMean(int[] heights) {
		int sum = toCalculateSum(heights);
		int players = heights.length;
		
		double mean = (double)sum / (double)players;
		return mean;
	}
	
	public static int findShortestHeight(int[] heights) {
		int shortest = heights[0];
		for (int index = 0; index < heights.length; index++) {
			if (heights[index] < shortest) {
				shortest = heights[index];
			}
		}
		return shortest;
	}
	
	public static int findTallestHeight(int[] heights) {
		int tallest = heights[0];
		for (int tall : heights) {
			if (tall > tallest) {
				tallest = tall;
			}
		}
		return tallest;
	}

	public static void main(String[] args) {
		int[] heights = new int[11];
		for (int i = 0; i < heights.length; i++) {
			heights[i] = (int)((Math.random() * 101) + 150);
		}
		
		int sum = toCalculateSum(heights);
		double mean = toCalculateMean(heights);
		int shortest = findShortestHeight(heights);
		int tallest = findTallestHeight(heights);
		
		// Display results
		int player = 1;
		for (int height : heights) {
			System.out.println("Player " + player++ + " height: " + height);
		}
		
		System.out.println("Sum: " + sum);
		System.out.println("Mean: " + mean);
		System.out.println("Shorest Height: " + shortest);
		System.out.println("Tallest Height: " + tallest);
	}
}