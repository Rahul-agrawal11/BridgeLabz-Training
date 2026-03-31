package QuestionsSolution;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

class File {

	String version;
	int size;

	public File(String version, int size) {

		this.version = version;
		this.size = size;
	}

	public String getVersion() {
		return version;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return version + " " + size;
	}

}

public class StorageSystem {

	LinkedHashMap<String, ArrayList<File>> files = new LinkedHashMap<>();
	ArrayList<File> fi = new ArrayList<>();

	public void uploadFile(String fileName, String version, int size) {
		for (File f : fi) {
			if (f.getVersion().equals(version)) {
				return;
			}
		}
		if (!files.containsKey(fileName)) {
			files.put(fileName, new ArrayList<>());
		}
		files.get(fileName).add(new File(version, size));
	}

	public void fetchFile(String fileName) {
		if (files.containsKey(fileName)) {
			ArrayList<File> f = files.get(fileName);
			f.stream().sorted(Comparator.comparingInt(File::getSize).thenComparing(File::getVersion))
					.forEach(s -> System.out.println(fileName + " " + s));
		} else {
			System.out.println("File Not Found");
		}
	}

	public void latestFile(String fileName) {
		if (files.containsKey(fileName)) {
			ArrayList<File> f = files.get(fileName);
			System.out.println(fileName + " " + f.get(f.size() - 1));
		} else {
			System.out.println("File Not Found");
		}
	}

	public void totalStorage(String fileName) {
		ArrayList<File> f = files.get(fileName);
		int sum = 0;
		for (File n : f) {
			sum += n.getSize();
		}
		System.out.println(fileName + " " + sum);
	}

	public static void main(String[] args) {
		StorageSystem ss = new StorageSystem();
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < len; i++) {
			String data = sc.nextLine();
			String[] details = data.split(" ");
			if (details[0].equals("UPLOAD")) {
				ss.uploadFile(details[1], details[2], Integer.parseInt(details[3]));
			} else if (details[0].equals("FETCH")) {
				ss.fetchFile(details[1]);
			} else if (details[0].equals("LATEST")) {
				ss.latestFile(details[1]);
			} else if (details[0].equals("TOTAL_STORAGE")) {
				ss.totalStorage(details[1]);
			}
		}

//		for (int i = 0; i < len; i++) {
//			String data = sc.nextLine();
//			String[] d = data.split(" ");
//			if (d[0].equals("UPLOAD")) {
//
//				list.add(new File(d[1], d[2], Double.parseDouble(d[3])));
//			} else if (d[0].equals("FETCH")) {
//				for (File f : list) {
//					if (f.getFileName().equals(d[1])) {
//						System.out.println(f);
//					}
//				}
//			} else if (d[0].equals("LATEST")) {
//				for (int j = list.size() - 1; j >= 0; j--) {
//					if (list.get(j).getFileName().equals(d[1])) {
//						System.out.println(list.get(j));
//						break;
//					}
//				}
//			} else if (d[0].equals("TOTAL_STORAGE")) {
//				double sum = 0;
//				for (File f : list) {
//					if (f.getFileName().equals(d[1])) {
//						sum += f.getSize();
//					}
//				}
//				System.out.println(d[1] + " " + sum);
//			}
//		}
		sc.close();
	}
}
