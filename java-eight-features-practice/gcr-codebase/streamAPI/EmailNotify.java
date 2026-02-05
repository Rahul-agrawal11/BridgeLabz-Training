package streamAPI;

import java.util.*;

public class EmailNotify {

    static void sendEmailNotification(String email) {
        System.out.println("Sending email to: " + email);
    }

    public static void main(String[] args) {

        List<String> emails = Arrays.asList("a@gmail.com", "b@gmail.com", "c@gmail.com");

        emails.forEach(EmailNotify::sendEmailNotification);
    }
}
