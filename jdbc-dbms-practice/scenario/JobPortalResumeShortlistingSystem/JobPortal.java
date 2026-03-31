package scenario.JobPortalResumeShortlistingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class JobPortal {

    private List<Resume> resumes = new ArrayList<>();

    // Add Resume with validation
    public boolean addResume(Resume resume) throws InvalidResumeException {

        if (resume == null) {
            throw new InvalidResumeException("Resume cannot be null!");
        }

        if (resume.getCandidateName() == null || resume.getCandidateName().trim().isEmpty()) {
            throw new InvalidResumeException("Candidate name cannot be empty!");
        }

        if (resume.getSkills() == null || resume.getSkills().isEmpty()) {
            throw new InvalidResumeException("Skills cannot be empty!");
        }

        resumes.add(resume);
        return true;
    }

    // Shortlist resumes based on required skills
    public List<Resume> shortlistResumes(Set<String> requiredSkills) {

        // copy list
        List<Resume> result = new ArrayList<>(resumes);

        // Sort using Comparator (descending by match count)
        result.sort((r1, r2) -> Integer.compare(
                r2.getSkillMatchCount(requiredSkills),
                r1.getSkillMatchCount(requiredSkills)
        ));

        return result;
    }
}