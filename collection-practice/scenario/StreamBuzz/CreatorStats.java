package scenario.StreamBuzz;

import java.util.ArrayList;
import java.util.List;

public class CreatorStats {
	
	public static List<CreatorStats> EngagementBoard = new ArrayList<>();
	
	String CreatorName;
	private double[] WeeklyLikes = new double[4];
	public CreatorStats(String creatorName, double[] weeklyLikes) {
		CreatorName = creatorName;
		WeeklyLikes = weeklyLikes;
	}
	public double[] getWeeklyLikes() {
		return WeeklyLikes;
	}
	public void setWeeklyLikes(double[] weeklyLikes) {
		WeeklyLikes = weeklyLikes;
	}
	
}
