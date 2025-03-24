import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // filter, use to filter the elements
        Stream<String> nameStream = Stream.of("Hello", "Everybody", "How", "Are", "you", "Doing");
        Stream<String> filteredStream = nameStream.filter((String s) -> (s.length() <= 3));

        List<String> filteredNameList = filteredStream.collect(Collectors.toList());

        System.out.println("After Filter Operation");
        // list after filter
        for (String el: filteredNameList){
            System.out.print(el + " ");
        }
        System.out.println();
        System.out.println("After Map Operation");
        // map, for the transformation

        Stream<String> nameStream1 = Stream.of("Hello", "Everybody", "How", "Are", "you", "Doing");
        Stream<String> mapStream = nameStream1.map((String el) -> el.toUpperCase());
        List<String> mappedNameList = mapStream.collect(Collectors.toUnmodifiableList());

        // list after map
        for (String el: mappedNameList){
            System.out.print(el + " ");
        }

        System.out.println();

        //flatMap (for complex data)
        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("i", "Love", "java"),
                Arrays.asList("concepts", "are", "clear"),
                Arrays.asList("It", "is", "very", "easy")
        );

        Stream<String> flatMapExample = sentenceList.stream().flatMap((List<String> sentence) -> sentence.stream().map((String word) -> word.toUpperCase()));

        List<String> stringAfterStreamOp = flatMapExample.collect(Collectors.toList());

        System.out.println("Stream After flatmap Operation");
        stringAfterStreamOp.forEach((String s) -> System.out.print(s + " "));
        System.out.println();


        // distinct

        Integer[] arr = {1, 5, 2, 7, 4, 4, 9};

        Stream<Integer> streamInt = Arrays.stream(arr).distinct();

        List<Integer> newArr = streamInt.collect(Collectors.toList());

        // print after distinct operation
        System.out.println("Stream After Distinct operation");
        newArr.forEach((Integer el) -> System.out.print(el + " "));
        System.out.println();

        Integer[] arr1 = {1, 5, 2, 7, 4, 4, 9};

        Stream<Integer> streamInt1 = Arrays.stream(arr).sorted();

        System.out.println("Stream After Sorted operation");

        streamInt1.collect(Collectors.toList()).forEach((Integer el) -> System.out.print(el + " "));

        System.out.println();


        // why lazy ?

        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> numberStream = numbers.stream().filter((Integer a) -> a >= 3).peek((Integer a) -> System.out.println(a));

        // nothing will be printed if terminator is not executed

        System.out.println("numbers greater than 3, after lazy operation: ");

        numberStream.count(); // now print will be done, that's why intermediate operations are lazy


        // parallel stream

        List<Integer> numbers2 = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110);

        // sequential processing
        long sequantialProcessingStartTime = System.currentTimeMillis();

        numbers2.stream().map((Integer val) -> val * val).forEach((Integer val) -> System.out.print(val + " "));

        System.out.println();
        System.out.println("Sequantial Processing time taken " + (System.currentTimeMillis() - sequantialProcessingStartTime) + "ms");

        System.out.println("parallel processing");

        long parallelProcessingStartTime = System.currentTimeMillis();

        numbers2.parallelStream().map((Integer val) -> val * val).forEach((Integer val) -> System.out.print(val + " "));

        System.out.println();
        System.out.println("parallel Processing time taken " + (System.currentTimeMillis() - parallelProcessingStartTime) + "ms");

    }
}