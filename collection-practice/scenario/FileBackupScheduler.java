package scenario;

import java.util.*;

//BackupTask class
class BackupTask implements Comparable<BackupTask> {
 String path;
 int priority;

 BackupTask(String path, int priority) {
     this.path = path;
     this.priority = priority;
 }

 @Override
 public int compareTo(BackupTask other) {
     // Higher priority comes first
     return Integer.compare(other.priority, this.priority);
 }

 @Override
 public String toString() {
     return "Path: " + path + ", Priority: " + priority;
 }
}

//Custom Exception
class InvalidBackupPathException extends Exception {
 InvalidBackupPathException(String message) {
     super(message);
 }
}

public class FileBackupScheduler {

 static PriorityQueue<BackupTask> queue = new PriorityQueue<>();

 // Add backup task
 static boolean addTask(String path, int priority) throws InvalidBackupPathException {
     if (path == null || path.trim().isEmpty()) {
         throw new InvalidBackupPathException("Invalid backup path!");
     }

     queue.add(new BackupTask(path, priority));
     return true;
 }

 // Execute tasks
 static void executeTasks() {
     if (queue.isEmpty()) {
         System.out.println("No backup tasks scheduled!");
         return;
     }

     System.out.println("\nExecuting Backup Tasks (High Priority First):");
     while (!queue.isEmpty()) {
         BackupTask task = queue.poll();
         System.out.println("Backing up: " + task.path + " | Priority: " + task.priority);
     }
 }

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     while (true) {
         System.out.println("\n===== File Backup Scheduler =====");
         System.out.println("1. Add Backup Task");
         System.out.println("2. Execute Backup Tasks");
         System.out.println("3. Exit");
         System.out.print("Enter your choice: ");

         int choice = sc.nextInt();
         sc.nextLine(); // consume newline

         switch (choice) {

             case 1:
                 try {
                     System.out.print("Enter Folder Path: ");
                     String path = sc.nextLine();

                     System.out.print("Enter Priority (1-10): ");
                     int priority = sc.nextInt();

                     boolean added = addTask(path, priority);
                     if (added) {
                         System.out.println("Backup task added successfully!");
                     }

                 } catch (InvalidBackupPathException e) {
                     System.out.println(e.getMessage());
                 }
                 break;

             case 2:
                 executeTasks();
                 break;

             case 3:
                 System.out.println("Exiting scheduler...");
                 sc.close();
                 return;

             default:
                 System.out.println("Invalid choice!");
         }
     }
 }
}

