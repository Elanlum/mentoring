package lambda_stream.task_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class aPersonStream {

    static Comparator<Person> byName = Comparator.comparing(Person::getName);
    static Comparator<Person> byAge = Comparator.comparing(Person::getAge);

    public static void main(String[] args) {
        List<Person> people = localPersonFactory();

        printSortedByAgeAndName(people);
    }

    public static void printSortedByAgeAndName(List<Person> inputList) {
        inputList.stream()
                .sorted(byAge)
                .sorted(byName)
                .forEach(person -> System.out.println(person.toString()));
    }

    private static List<Person> localPersonFactory(){
        return Arrays.asList(
                new Person("Karen", 50),
                new Person("Adam", 50),
                new Person("Vagram", 30),
                new Person("Suleika", 18));
    }
}
