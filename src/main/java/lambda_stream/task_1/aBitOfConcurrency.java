package lambda_stream.task_1;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class aBitOfConcurrency {

    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Runnable shoutable = () -> System.out.println("I'm the first Runnable\n------------");
        Runnable threadable = () -> System.out.println("Executing by " + Thread.currentThread().getName() + " thread.\n------------");
        Runnable multiplyable = () -> {
            List<Integer> result = list.stream()
                    .map(a -> a * 5)
                    .collect(toList());

            System.out.println(result + "\n------------");
        };

        Thread exampleAlive = new Thread(shoutable);
        exampleAlive.start();

        Thread exampleThreadName = new Thread(threadable);
        exampleThreadName.start();

        Thread listMultiplyExample = new Thread(multiplyable);
        listMultiplyExample.start();
    }
}
