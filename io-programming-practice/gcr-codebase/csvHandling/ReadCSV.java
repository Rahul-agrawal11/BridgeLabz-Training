package csvHandling;

import java.io.*;

public class ReadCSV {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\itz_r\\eclipse-workspace\\ioprogramming\\src\\csvHandling\\students.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				System.out.println(columns[0] + "\t" + columns[1] + "\t" + columns[2] + "\t" + columns[3]);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
