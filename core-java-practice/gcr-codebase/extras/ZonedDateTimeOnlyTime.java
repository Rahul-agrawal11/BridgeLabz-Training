import java.time.*;

class ZonedDateTimeOnlyTime {
    public static LocalTime getGMTTime() {
        return ZonedDateTime.now(ZoneId.of("UTC")).toLocalTime();
    }

    public static LocalTime getISTTime() {
        return ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toLocalTime();
    }

    public static LocalTime getPSTTime() {
        return ZonedDateTime.now(ZoneId.of("America/Los_Angeles")).toLocalTime();
    }

    public static void main(String[] args) {
        
        System.out.println("GMT: " + getGMTTime());
        System.out.println("IST: " + getISTTime());
        System.out.println("PST: " + getPSTTime());
    }
}