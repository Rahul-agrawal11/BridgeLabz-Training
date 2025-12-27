import java.util.Scanner;

class BodyMassIndex2d {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int number = input.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input section
        for (int i = 0; i < number; i++) {

            System.out.println("\nEnter details for Person " + (i + 1));

            // Weight
            System.out.print("Enter weight (kg): ");
            personData[i][0] = input.nextDouble();

            // Height in cm → meters
            System.out.print("Enter height (cm): ");
            double heightCm = input.nextDouble();
            personData[i][1] = heightCm / 100;

            // BMI calculation
            personData[i][2] =
                    personData[i][0] /
                    (personData[i][1] * personData[i][1]);

            // Weight status
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 40) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Output
        System.out.println("\nPerson\tWeight\tHeight(m)\tBMI\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf(
                "%d\t%.2f\t%.2f\t\t%.2f\t%s%n",
                (i + 1),
                personData[i][0],
                personData[i][1],
                personData[i][2],
                weightStatus[i]
            );
        }
    }
}
