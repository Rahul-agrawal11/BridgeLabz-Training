package scenario.JobPortalResumeShortlistingSystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResumeMain {
	public static void main(String[] args) {

		JobPortal portal = new JobPortal();

		try {
			portal.addResume(new Resume(1, "Rahul", new HashSet<>(Arrays.asList("Java", "SQL", "Spring", "Git"))));

			portal.addResume(new Resume(2, "Amit", new HashSet<>(Arrays.asList("Java", "Python", "DSA"))));

			portal.addResume(new Resume(3, "Neha", new HashSet<>(Arrays.asList("React", "JavaScript", "HTML", "CSS"))));

			// Invalid resume (empty skills)
			portal.addResume(new Resume(4, "Rohit", new HashSet<>()));

		} catch (InvalidResumeException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		Set<String> requiredSkills = new HashSet<>(Arrays.asList("Java", "Spring", "SQL"));

		System.out.println("\n--- Shortlisted Resumes (Sorted by Match Count) ---");

		List<Resume> shortlisted = portal.shortlistResumes(requiredSkills);

		for (Resume r : shortlisted) {
			System.out.println(r.getCandidateName() + " | Match Count: " + r.getSkillMatchCount(requiredSkills)
					+ " | Skills: " + r.getSkills());
		}
	}
}
