package multiThreading.downloadManager;

import java.util.Random;

class FileDownloader extends Thread {
    private String fileName;
    private Random random = new Random();

    public FileDownloader(String fileName) {
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

public class DownloadManagerThreadApproach {
    public static void main(String[] args) throws InterruptedException {

        FileDownloader d1 = new FileDownloader("Document.pdf");
        FileDownloader d2 = new FileDownloader("Image.jpg");
        FileDownloader d3 = new FileDownloader("Video.mp4");

        d1.start();
        d2.start();
        d3.start();

        // Main thread waits for all downloads
        d1.join();
        d2.join();
        d3.join();

        System.out.println("All downloads complete!");
    }
}
