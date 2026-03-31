package scenario.OnlineClassroomAttendanceTracker;

import java.util.*;

class AttendanceService {

    // Stores all registered students (no duplicates)
    private Set<String> students = new HashSet<>();

    // Session-wise attendance
    private Map<String, Set<String>> sessionAttendance = new HashMap<>();

    // Register student
    public boolean registerStudent(String studentId) {
        return students.add(studentId);
    }

    // Mark attendance
    public boolean markAttendance(String sessionId, String studentId)
            throws DuplicateAttendanceException {

        if (!students.contains(studentId)) {
            throw new IllegalArgumentException("Student not registered: " + studentId);
        }

        // Create session set if not exists
        sessionAttendance.putIfAbsent(sessionId, new HashSet<>());

        Set<String> presentStudents = sessionAttendance.get(sessionId);

        if (presentStudents.contains(studentId)) {
            throw new DuplicateAttendanceException(
                    "Attendance already marked for Student: " + studentId +
                            " in Session: " + sessionId
            );
        }

        presentStudents.add(studentId);
        return true;
    }

    // Remove attendance (if wrongly marked)
    public boolean removeAttendance(String sessionId, String studentId) {

        if (!sessionAttendance.containsKey(sessionId)) {
            return false;
        }

        Set<String> presentStudents = sessionAttendance.get(sessionId);
        return presentStudents.remove(studentId);
    }

    // Display attendance for a session
    public Set<String> getAttendanceBySession(String sessionId) {

        if (!sessionAttendance.containsKey(sessionId)) {
            return new HashSet<>();
        }

        return sessionAttendance.get(sessionId);
    }

    // Display all sessions attendance
    public Map<String, Set<String>> getAllSessionAttendance() {
        return sessionAttendance;
    }

    // Print nicely
    public void displayAllAttendance() {

        System.out.println("\n--- Session Wise Attendance ---");

        if (sessionAttendance.isEmpty()) {
            System.out.println("No attendance marked yet.");
            return;
        }

        for (Map.Entry<String, Set<String>> entry : sessionAttendance.entrySet()) {
            System.out.println("Session: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}