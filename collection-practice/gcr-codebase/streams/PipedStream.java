package streams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStream {

    public static void main(String[] args) throws IOException {

        // Create piped streams
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        // Writer Thread
        Thread writer = new Thread(() -> {
            String data = "Hello from Writer Thread!";
            try {
                pos.write(data.getBytes());
                pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Reader Thread
        Thread reader = new Thread(() -> {
            int b;
            try {
                while ((b = pis.read()) != -1) {
                    System.out.print((char) b);
                }
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Start threads
        writer.start();
        reader.start();
    }
}
