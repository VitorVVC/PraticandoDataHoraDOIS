import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Saudacão referente ao horário
        printSaudacao();
        // Actually Day
        actuallyDate();
        // Actually Day in another time zones
        actuallyDateInAnotherTimeZones();

        // Receive another time zone
        //Instant instant = Instant.now();
        //System.out.print("Write Location: ");
        //String location = sc.next();
        //System.out.print("Write Your TimeZone: ");
        //String timeZone = sc.next();
        //printDateTimeInTimeZone(location,timeZone,instant);

        String person = "Mom";
        LocalDate birthday = LocalDate.of(1981, 1, 12);
        printPersonInfo(person, 12, 1, 1981);
        printAge(person, birthday);

        String person2 = "Dad";
        LocalDate birthday2 = LocalDate.of(1982, 5, 28);
        printPersonInfo(person2, 28, 5, 1982);
        printAge(person2, birthday2);


    }
    private static void printSaudacao() {
        int hour = LocalDateTime.now().getHour();
        // Saudacão referente ao horario do dia
        if (hour >= 6 && hour < 12) {
            System.out.println("Good Morning");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Good Afternoon");
        } else {
            System.out.println("Good Night");
        }
    }

    private static void actuallyDate() {
        // Oque há em aspas simples e ignorado pelo simpleDateFormat. Dessa forma o JAVA Entende que são trechos literais e não tenta interpret-los
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'Data: 'dd/MM/yyyy '& Hour: 'HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Method actuallyDate: ");
        System.out.println("Actually Day: ");
        System.out.println(formatter.format(now));
        System.out.println("Day: " + now.getDayOfMonth());
        System.out.println("Month: " + now.getMonth());
        System.out.println("Year: " + now.getYear());
        System.out.println("------------------------------------");
    }

    private static void printDateTimeInTimeZone(String location, String timezone, Instant instant) {
        // Método suporte para actuallyDateInAnotherTimeZones
        // Oque há em aspas simples e ignorado pelo simpleDateFormat. Dessa forma o JAVA Entende que são trechos literais e não tenta interpret-los
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'Data: 'dd/MM/yyyy '& Hour: 'HH:mm:ss");
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(timezone));
        System.out.printf("Location: %s %s%n", location, formatter.format(zonedDateTime));
    }

    private static void actuallyDateInAnotherTimeZones() {
        Instant instant = Instant.now();
        System.out.println("Method actuallyDateInAnotherTimeZones: ");
        printDateTimeInTimeZone("Portugal", "Europe/Lisbon", instant);
        printDateTimeInTimeZone("Mexico", "America/Mexico_City", instant);
        printDateTimeInTimeZone("Japan", "Asia/Tokyo", instant);
    }

    private static void printPersonInfo(String person, int day, int month, int year) {
        System.out.printf("Method printPersonInfo of %s%n", person);
        System.out.println(person + "Day of birthday: " + day);
        System.out.println(person + " Month of birthday: " + month);
        System.out.println(person + " Year of birthday: " + year);
    }

    private static void printAge(String person, LocalDate birthdate) {
        LocalDate now = LocalDate.now();
        //Duration age = Duration.between(birthdate,now);
        Period age = Period.between(birthdate, now);
        System.out.printf("Method PrintAge of %s%n", person);
        System.out.println(person + " Age: " + age.getYears());
    }
}