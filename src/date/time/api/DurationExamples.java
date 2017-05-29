package date.time.api;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Use Duration class to day unit (Period class above)
 */
public class DurationExamples {

    public static void main(String[] args) {
        Duration fiveMinutes = Duration.ofMinutes(5);
        Duration sevenMinutes = fiveMinutes.plusMinutes(2);
        System.out.println(sevenMinutes.getSeconds());

        LocalDateTime firstMay = LocalDateTime.of(2017, 5, 1, 0, 0);
        LocalDateTime firstJune = LocalDateTime.of(2017, 6, 1, 0, 0);
        Duration oneMonth = Duration.between(firstMay, firstJune);
        System.out.println(oneMonth.getSeconds());
    }
}
