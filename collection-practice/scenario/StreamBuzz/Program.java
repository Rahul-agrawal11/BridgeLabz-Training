package scenario.StreamBuzz;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//import java.util.LinkedHashMap;

public class Program {
	public void RegisterCreator(CreatorStats record) {
		CreatorStats.EngagementBoard.add(record);
		System.out.println("Creator registered successfully!");
	}
	
	public LinkedHashMap<String, Integer> GetTopPostCounts(List<CreatorStats> records, double likeThreshold) {
		LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();
		for (CreatorStats c : records) {
			int count = 0;
			for(double likes : c.getWeeklyLikes()) {
				if(likes >= likeThreshold) {
					count++;
				}
			}
			if(count > 0) {
				result.put(c.CreatorName, count);
			}
		}
		return result;
	}
	
	public double CalculateAverageLikes() {
		double totalLikes = 0;
		int totalWeeks = 0;
		for(CreatorStats c : CreatorStats.EngagementBoard) {
			for(double weeklyLikes : c.getWeeklyLikes()) {
				totalLikes += weeklyLikes;
				totalWeeks++;
			}
		}
		if(totalWeeks == 0) {
			return 0;
		}
		return totalLikes / totalWeeks;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Program program = new Program();
		int choice;
		do {
			System.out.println("\n1. Register Creator: ");
			System.out.println("2. Show Top Posts: ");
			System.out.println("3. Calculate Average Likes: ");
			System.out.println("4. Exit: ");
			System.out.println("Enter your choice: ");
			choice = input.nextInt();
			input.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Creator Name: ");
				String name = input.nextLine();
				
				System.out.println("Enter Weekly Likes(Week 1 to 4): ");
				double[] likes = new double[4];
				for (int i = 0; i < likes.length; i++) {
					likes[i] = input.nextDouble();
				}
				input.nextLine();
				program.RegisterCreator(new CreatorStats(name, likes));
				break;
			case 2:
				System.out.println("Enter like threshold: ");
				double likeThreshold = input.nextDouble();
				input.nextLine();
				LinkedHashMap<String, Integer> result = program.GetTopPostCounts(CreatorStats.EngagementBoard, likeThreshold);
				if (result.isEmpty()) {
					System.out.println("No top-performing posts this week");
				} else {
					for(Map.Entry<String, Integer> entry : result.entrySet()) {
						System.out.println(entry.getKey() + "-" + entry.getValue());
					}
				}
				break;
			case 3:
				double avgLikes = program.CalculateAverageLikes();
				System.out.println("Overall Average Weekly Likes: " + (int)avgLikes);
				break;
			case 4:
				System.out.println("Logging off - Keep Creating with StreamBuzz!");
				break;
			default:
				System.out.println("Invalid Choice!");
			}
		} while(choice != 4);
		input.close();
	}
}
