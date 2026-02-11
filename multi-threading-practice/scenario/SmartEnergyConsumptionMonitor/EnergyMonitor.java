package scenario.SmartEnergyConsumptionMonitor;

import java.util.*;

class EnergyMonitor {

    // Map<Date, List<Double>>
    private Map<String, List<Double>> usageData = new HashMap<>();

    // Add energy reading
    public boolean addReading(String date, double reading)
            throws InvalidEnergyReadingException {

        if (reading < 0) {
            throw new InvalidEnergyReadingException("Energy reading cannot be negative: " + reading);
        }

        usageData.putIfAbsent(date, new ArrayList<>());
        usageData.get(date).add(reading);
        return true;
    }

    // Daily average
    public double getDailyAverage(String date) {

        if (!usageData.containsKey(date)) return 0.0;

        List<Double> readings = usageData.get(date);
        double sum = 0;

        for (double r : readings) sum += r;

        return sum / readings.size();
    }

    // Monthly average (month = "2026-02")
    public double getMonthlyAverage(String month) {

        double total = 0;
        int count = 0;

        for (Map.Entry<String, List<Double>> entry : usageData.entrySet()) {

            String date = entry.getKey();
            if (date.startsWith(month)) {

                for (double reading : entry.getValue()) {
                    total += reading;
                    count++;
                }
            }
        }

        if (count == 0) return 0.0;
        return total / count;
    }

    // Report
    public void printReport() {

        System.out.println("\n--- Energy Usage Report ---");

        for (String date : usageData.keySet()) {
            System.out.println(date + " -> Readings: " + usageData.get(date)
                    + " | Avg: " + getDailyAverage(date));
        }
    }
}