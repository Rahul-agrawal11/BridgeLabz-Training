public class EmployeeWageComputation {

    // UC2: Constants for wage calculation
    static final int WAGE_PER_HOUR = 20;

    // UC1 & UC3: Employee status constants
    static final int ABSENT = 0;
    static final int FULL_TIME = 1;
    static final int PART_TIME = 2;

    // UC2 & UC3: Working hours
    static final int FULL_DAY_HOURS = 8;
    static final int PART_TIME_HOURS = 4;

    // UC5: Total working days in a month
    static final int TOTAL_DAYS = 20;

    public static void main(String[] args) {

        // UC1: Display welcome message
        System.out.println("Welcome to Employee Wage Computation Program\n");

        // UC5: Calculate wages for 20 days
        int totalWage = calculateWagesFor20Days();

        // UC5: Display total wage after 20 days
        System.out.println("\n-----------------------------------");
        System.out.println("Total Wage for 20 Days: " + totalWage);
    }

    // UC5: Method to calculate wage for 20 working days
    static int calculateWagesFor20Days() {

        int totalWage = 0;

        // UC5: Loop for 20 days
        for (int day = 1; day <= TOTAL_DAYS; day++) {

            // UC1: Check employee attendance using RANDOM
            int empType = getEmployeeType();

            // UC2 & UC3: Get working hours based on employee type
            int hoursWorked = getWorkingHours(empType);

            // UC2: Calculate daily wage
            int dailyWage = hoursWorked * WAGE_PER_HOUR;

            totalWage += dailyWage;

            // UC1, UC2, UC3: Display daily details
            System.out.println(
                "Day " + day +
                " | Attendance: " + getAttendanceStatus(empType) +
                " | EmpType: " + getEmployeeTypeName(empType) +
                " | Daily Wage: " + dailyWage
            );
        }
        return totalWage;
    }

    // UC1: Generate random employee type (Absent / Full-time / Part-time)
    static int getEmployeeType() {
        return (int) (Math.random() * 3); // 0,1,2
    }

    // UC2 & UC3 & UC4: Determine working hours using switch case
    static int getWorkingHours(int empType) {

        switch (empType) {

            // UC2: Full-time employee
            case FULL_TIME:
                return FULL_DAY_HOURS;

            // UC3: Part-time employee
            case PART_TIME:
                return PART_TIME_HOURS;

            // UC1: Absent employee
            default:
                return 0;
        }
    }

    // UC1: Display attendance status
    static String getAttendanceStatus(int empType) {
        return empType == ABSENT ? "Absent" : "Present";
    }

    // UC3 & UC4: Display employee type name
    static String getEmployeeTypeName(int empType) {

        switch (empType) {
            case FULL_TIME:
                return "Full Time";

            case PART_TIME:
                return "Part Time";

            default:
                return "Absent";
        }
    }
}