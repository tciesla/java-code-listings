package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {

        List<String> numbers = Arrays.asList("one", "two", "three", "four", "five");

        // obtain stream from the list
        Stream<String> numbersStream = numbers.stream();

        // filter stream to obtain numbers that starts with t character
        List<String> filteredNumbers = numbersStream.filter(s -> s.startsWith("t")).collect(Collectors.toList());
        System.out.println(filteredNumbers);

        // map numbers in stream to upper case letters
        List<String> mappedNumbers = numbers.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(mappedNumbers);

        // sort numbers in stream using standard comparator
        List<String> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }

}
