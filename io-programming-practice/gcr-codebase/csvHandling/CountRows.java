package csvHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\students.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			// Exclude header row
			br.readLine();
			int totalRows = 0;
			while((br.readLine()) != null) {
				totalRows++;
			}
			System.out.println("Total Rows: " + totalRows);
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
