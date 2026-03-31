package multiThreading.downloadManager;

import java.util.Random;

class FileDownloaderRunnable implements Runnable {
    private String fileName;
    private Random random = new Random();

    public FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading " 
                               + fileName + ": " + progress + "%");

            try {
                // Random delay between 200ms to 800ms
                Thread.sleep(200 + random.nextInt(601));
            } catch (InterruptedException e) {
                System.out.println("Download interrupted for " + fileName);
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Finished downloading " + fileName);
    }
}

public class DownloadManagerRunnableApproach {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new FileDownloaderRunnable("Document.pdf"), "Thread-1");
        Thread t2 = new Thread(new FileDownloaderRunnable("Image.jpg"), "Thread-2");
        Thread t3 = new Thread(new FileDownloaderRunnable("Video.mp4"), "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        // Main thread waits for all downloads
        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}
