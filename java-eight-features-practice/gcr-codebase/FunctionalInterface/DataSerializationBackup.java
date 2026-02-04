package FunctionalInterface;

import java.io.*;

class UserBackupData implements Serializable {
    private String username;
    private int age;

    public UserBackupData(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBackupData{username='" + username + "', age=" + age + "}";
    }
}

class BackupProcessor {

    public static boolean backupObject(Object obj, String fileName) {

        if (!(obj instanceof Serializable)) {
            System.out.println("Backup failed: Object is not Serializable!");
            return false;
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(obj);
            System.out.println("Backup stored successfully in file: " + fileName);
            return true;

        } catch (IOException e) {
            System.out.println("Backup failed: " + e.getMessage());
            return false;
        }
    }
}

public class DataSerializationBackup {
    public static void main(String[] args) {

        UserBackupData data = new UserBackupData("Rahul", 22);

        BackupProcessor.backupObject(data, "backup.dat");
    }
}
