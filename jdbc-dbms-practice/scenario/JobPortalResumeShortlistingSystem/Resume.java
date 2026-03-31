package scenario.JobPortalResumeShortlistingSystem;

import java.util.Set;

class Resume {
    private int resumeId;
    private String candidateName;
    private Set<String> skills;

    public Resume(int resumeId, String candidateName, Set<String> skills) {
        this.resumeId = resumeId;
        this.candidateName = candidateName;
        this.skills = skills;
    }

    public int getResumeId() {
        return resumeId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public Set<String> getSkills() {
        return skills;
    }

    // Count how many required skills match
    public int getSkillMatchCount(Set<String> requiredSkills) {
        int count = 0;
        for (String skill : requiredSkills) {
            if (skills.contains(skill)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Resume{ID=" + resumeId +
                ", Name='" + candidateName + "'" +
                ", Skills=" + skills + "}";
    }
}
