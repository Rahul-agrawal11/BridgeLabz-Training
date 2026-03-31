package scenario.SmartEnergyConsumptionMonitor;

public class EnergyMain {
	public static void main(String[] args) {

		EnergyMonitor monitor = new EnergyMonitor();

		try {
			monitor.addReading("2026-02-10", 5.2);
			monitor.addReading("2026-02-10", 4.8);
			monitor.addReading("2026-02-11", 6.1);

			monitor.addReading("2026-02-11", -2.0); // invalid

		} catch (InvalidEnergyReadingException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		monitor.printReport();

		System.out.println("\nMonthly Avg (2026-02): " + monitor.getMonthlyAverage("2026-02"));
	}
}
