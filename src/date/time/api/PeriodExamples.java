package date.time.api;

import java.time.LocalDate;
import java.time.Period;

/**
 * Use Period class from day unit (Duration class below)
 */
public class PeriodExamples {

    public static void main(String[] args) {
        Period fiveMonths = Period.ofMonths(5);
        Period threeMonths = Period.ofMonths(3);
        Period eightMonths = fiveMonths.plus(threeMonths);
        System.out.println(eightMonths.getMonths());

        LocalDate localDate1 = LocalDate.of(1990, 1, 1);
        LocalDate localDate2 = LocalDate.of(1992, 1, 1);
        Period twoYears = Period.between(localDate1, localDate2);
        System.out.println(twoYears.getYears());
    }
}
