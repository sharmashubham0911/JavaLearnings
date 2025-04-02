import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static boolean isPrime(int number) {
        if (number % 2 == 0) return true;
        return false;
    }

//    Static Classes
//     Person Class

    static class Person{

        String name;
        int age;

        Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        int getAge(){
            return this.age;
        }
    }

    static class Transaction{

    }

    public static void main(String[] args) {

        // filter, use to filter the elements
        Stream<String> nameStream = Stream.of("Hello", "Everybody", "How", "Are", "you", "Doing");
        Stream<String> filteredStream = nameStream.filter((String s) -> (s.length() <= 3));

        List<String> filteredNameList = filteredStream.collect(Collectors.toList());

        System.out.println("After Filter Operation");
        // list after filter
        for (String el : filteredNameList) {
            System.out.print(el + " ");
        }
        System.out.println();
        System.out.println("After Map Operation");
        // map, for the transformation

        Stream<String> nameStream1 = Stream.of("Hello", "Everybody", "How", "Are", "you", "Doing");
        Stream<String> mapStream = nameStream1.map((String el) -> el.toUpperCase());
        List<String> mappedNameList = mapStream.collect(Collectors.toUnmodifiableList());

        // list after map
        for (String el : mappedNameList) {
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


//         Questions

//        Q. Find the longest string in a list of strings using Java streams:

        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");

        Optional<String> longestString = strings.stream().max(Comparator.comparingInt(String::length));

        System.out.println(longestString.get());

//        Q. Calculate the average age of a list of Person objects using Java streams:

        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );


        double averageAge = persons.stream().mapToInt(Person::getAge).average().orElse(0);

        System.out.println(averageAge);

//        Q. Check if a list of integers contains a prime number using Java streams:

        List<Integer> numbers1 = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);

        List<Integer> numbers3 = Arrays.asList(1, 5, 7);

        boolean isContainsPrime = numbers1.stream().anyMatch(Main::isPrime);

        System.out.println(isContainsPrime);

        isContainsPrime = numbers3.stream().anyMatch(Main::isPrime);
        System.out.println(isContainsPrime);


//        Q. Merge two sorted lists into a single sorted list using Java streams:

        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());

        mergedList.forEach(a -> System.out.print(a + " "));

//        Q. Find the intersection of two lists using Java streams:

        list1 = Arrays.asList(1, 2, 3, 4, 5);
        list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> intersection = list1.stream().filter(list2::contains).collect(Collectors.toList());

//        Q. Remove duplicates from a list while preserving the order using Java streams:

        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);

        numbersWithDuplicates.stream().distinct().collect(Collectors.toList());


//        Q. Find the kth smallest element in an array using Java streams:

        int[] array = {4, 2, 7, 1, 5, 3, 6};

        int thirdSmallest = Arrays.stream(array).sorted().skip(2).findFirst().orElse(-1);

        System.out.println();
        System.out.println(thirdSmallest);


//        Q. Given a list of strings, find the frequency of each word using Java streams:

        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");

        Map<String, Long> freq = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        collect: retuns a map
//        Collectors.groupingBy(...) is a collector that groups elements based on a classification function and then performs a reduction operation on the grouped elements.
//        Collectors.counting() is a collector that counts the number of elements in each group.

//        Q. Implement a method to partition a list into two groups based on a predicate using Java streams:

        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer>> partition = numbers.stream().collect(Collectors.partitioningBy(a -> a % 2 == 0));

        List<Integer> partition1 = partition.get(true);
        List<Integer> partition2 = partition.get(false);

        System.out.println("First Partition");
        partition1.forEach(a -> System.out.print(a + " "));

        System.out.println();
        System.out.println("Second Partition");
        partition2.forEach(a -> System.out.print(a + " "));

        System.out.println();

    }
}