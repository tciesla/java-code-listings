package date.time.api;

import java.time.LocalDate;

/**
 * LocalDate uses only days. Use LocalDateTime to use minutes and seconds.
 */
public class LocalDateExamples {

    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(2017, 5, 29);
        System.out.println(localDate1);

        LocalDate localDate2 = localDate1.plusYears(2);
        System.out.println(localDate2);

        LocalDate localDate3 = localDate2.plusMonths(3);
        System.out.println(localDate3);

        LocalDate localDate4 = localDate3.minusDays(4);
        System.out.println(localDate4);
    }
}
