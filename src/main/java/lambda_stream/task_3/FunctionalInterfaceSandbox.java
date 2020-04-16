package lambda_stream.task_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalInterfaceSandbox {

    public static final int MULTIPLYER = 3;

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<String> namesList = Arrays.asList("Java", "Python", "JavaScript", "C");
        int[] initial = {1};
        Map<String, Integer> priceList = new HashMap<>();
        priceList.put("Mask", 40);
        priceList.put("Grecha", 100);
        priceList.put("Aeroflot ticket home", 500000);

        FunctionalInterfaceSandbox.functionMultiplyStreamValues(integerList, MULTIPLYER);
        FunctionalInterfaceSandbox.predicateFirstLetter(namesList, "J");
        FunctionalInterfaceSandbox.unaryOperatorToUpper(namesList);
        FunctionalInterfaceSandbox.binaryOperatorSumStream(integerList);
        FunctionalInterfaceSandbox.supplierArithmeticProgression(initial, 3);
        FunctionalInterfaceSandbox.consumerPrintPrice(priceList);
    }

    private static void functionMultiplyStreamValues(List<Integer> list, int multiplyer) {
        List<Integer> resultList = list.stream()
                .map(value -> value * multiplyer)
                .collect(Collectors.toList());

        System.out.println("Function example multiplies stream: " + resultList);
    }

    private static void predicateFirstLetter(List<String> list, String firstLetter) {
        List<String> resultList = list.stream()
                .filter(name -> name.startsWith(firstLetter))
                .collect(Collectors.toList());

        System.out.println(String.format("Only %d names start with letter %s : %s",
                resultList.size(), firstLetter, resultList));
    }

    private static void unaryOperatorToUpper(List<String> list) {
        list.replaceAll(String::toUpperCase);

        System.out.println("All names to upper case: " + list);
    }

    private static void binaryOperatorSumStream(List<Integer> list) {
        Integer sum = list.stream()
                .reduce(0, Integer::sum);
        System.out.println("Stream above sum = " + sum);
    }

    private static void supplierArithmeticProgression(int[] initial, int delta) {
        List<Integer> arithimeticTen = Stream.generate(() -> {
            int member = initial[0];
            initial[0] = initial[0] + delta;
            return member;
        })
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(String.format("First 10 members " +
                "of arithmetic progression are : %s", arithimeticTen));
    }

    private static void consumerPrintPrice(Map<String, Integer> list) {
        list.forEach((name, price) -> System.out.println(String.format("Cause of COVID-19 %s " +
                "price increased to %d", name, price)));
    }
}
