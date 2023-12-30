package concepts.and.coding.videos.streams;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Integer>salaries = new ArrayList<>();
        salaries.add(100);
        salaries.add(233);
        salaries.add(123);
        int cnt = 0;
        for (int sal:salaries){
            if (sal >=110)++cnt;
        }
        System.out.println(cnt);
        // using stream
        long count = salaries.stream().filter((Integer sal) -> sal > 110).count();
        System.out.println(count);

        /* Different ways to create stream in java*/
        // 1. from collection
        List<Integer>salaryList = Arrays.asList(2000,1122,2343);
        Stream<Integer>streamFromIntegerList = salaryList.stream();

        // 2. from arr
        Integer[]salaryArr = {2000,3400,1200,1239};
        Stream<Integer>streamFromIntegerArr = Arrays.stream(salaryArr);

        // 3. from static method
        Stream<Integer>streamFromStaticMethods = Stream.of(1000,2333,123234);

        // 4. from stream builder
        Stream.Builder<Integer>streamBuilder = Stream.builder();
        streamBuilder.add(1000).add(1335).add(12324);
        Stream<Integer>streamFromStreamBuilder = streamBuilder.build();

        //5. from stream iterate
        Stream<Integer>streamFromIterate = Stream.iterate(200,
                (Integer a)-> a + 5000)
                .limit(3);
        //streamFromIterate.forEach(val-> System.out.println(val));

        /*       Different intermediate operation ins stream        */
        // we can chain multiple intermediate operations together to perform
        // more complex processing before applying terminal operations

        // 1.  filter(Predicate<T>predicate) - filters the element
        // Predicate - function with one arg that returns a boolean value.
        // In java 8 - it is a function interface, it contains only an abstract method.
        Stream<String>nameString = Stream.of("Hello","EveryBody","How","are","u");
        Stream<String>filteredStream = nameString.filter((String name) ->
                name.length() > 3);
        List<String>filteredNameList = filteredStream.collect(Collectors.toList());
        //filteredNameList.forEach(System.out::println);

        // 2. map(Function<T,R>mapper) - used to transform each element
        nameString = Stream.of("Hello","EveryBody","How","are","u");
        Stream<String>nameInLowerCase = nameString.map(String::toLowerCase);
        //nameInLowerCase.forEach(System.out::println);

        // 3. flatMap(Function<T,Stream<R>>mapper) - used to iterate over each
        // element of the complex collection and helps to flatten it.
        List<List<String>>sentenceList = Arrays.asList(
                Arrays.asList("I","Love","Java"),
                Arrays.asList("Concepts","are","clear"),
                Arrays.asList("It's", "Very","easy")
        );
        Stream<String>wordStream = sentenceList.stream()
                .flatMap((List<String> sentence)->sentence.stream().filter(word-> !word.isEmpty())).map(word->word.toUpperCase());
        wordStream.forEach(System.out::println);
//        Map<Integer,List<String>> map = new HashMap<>();
//        map.put(1,Arrays.asList("I","Love","Java"));
//        map.put(2,Arrays.asList("Concepts","are","clear"));
//        map.put(3,Arrays.asList("It's", "Very","easy"));
        // distinct()
        Integer[]arr = {1,3,4,5,3,2,24,2,3};
        Stream<Integer>arrStream = Arrays.stream(arr).distinct();
        Stream<Integer>sortedStream = arrStream.sorted();
        //arrStream.forEach(a -> System.out.println(a));
        //sortedStream.forEach(System.out::println);

        // peek - peek(Consumer<T>action) - helps to see the intermediate result
        // of the stream which is getting processed
        List<Integer>integerList = Arrays.asList(1,3,4,1,5,12);
        Stream<Integer>integerStream = integerList.stream()
                .filter((Integer val)->val > 2)
                .peek(System.out::println)
                .map((Integer val)->-1*val);
        List<Integer>finalList = integerStream.collect(Collectors.toList());
        //finalList.forEach(System.out::println);

        // limit(long maxSize) - to truncate the stream, to have no longer than given maxsize
        List<Integer>numbers = Arrays.asList(1,3,4,5,1,23);
        Stream<Integer>numberStream = numbers.stream().limit(3);
        numberStream = numberStream.skip(2);
        List<Integer>numberList = numberStream.collect(Collectors.toList());
        //numberList.forEach(System.out::println);
        // mapToInt(ToIntFunction<T>mapper) -- helps to work with primitive int data types
        List<String>numberString = Arrays.asList("2","1","3","4");
        IntStream IntegerStream = numberString.stream().mapToInt(Integer::parseInt);
        int[]numberArr = IntegerStream.toArray();

        /* Different terminal operations*/
        // forEach(Consumer<T>action) - perform action on each element of the stream,do not return any value
        numbers = Arrays.asList(1,3,5,13);
//        numbers.stream()
//                .filter(val-> val>3)
//                .forEach(System.out::println);
        // toArray() - collects the elements of the steam in to an array
        List<Integer>list = Arrays.asList(1,3,5,1,3,5,10);
        Object[]filteredNumberArrType = list.stream().filter((Integer val)->val >= 3).toArray();
        Integer[] filteredNumberArrType2 =
                list.stream()
                .filter(val->val >= 3)
                .toArray(Integer[]::new);
        // reduce(BinaryOperator<T>accumulator) -
        // does reduction on the elements of stream. Perform associative aggregation function
        Optional<Integer>reducedValue = list.stream().reduce((Integer a, Integer b)->a+b);
        System.out.println(reducedValue.get());
        // min(Comparator<T>comparator) and max(Comparator<T>comparator)
        Optional<Integer>minvalueType = list.stream().filter((Integer val)->val >= 3)
                .min((Integer a, Integer b)->a-b);
        System.out.println(minvalueType.get());
        Optional<Integer>maxValueType = list.stream().filter((Integer a)-> a >= 3)
                .min((Integer a, Integer b)->b-a);
        System.out.println(maxValueType.get());

        // count() - returns the count of element present in the stream
        long noOfValuePresent = list.stream().filter((Integer val)->val>=3)
                .count();
        System.out.println(noOfValuePresent);

        boolean hasValueGreaterThanThree = list.stream()
                .anyMatch((Integer val)->val > 3);
        System.out.println(hasValueGreaterThanThree);
        boolean hasAllValuesGreaterThanThree = list.stream()
                .allMatch((Integer val)->val > 3);
        System.out.println(hasAllValuesGreaterThanThree);
        boolean hasNoneMatch = list.stream().noneMatch(val->val != 3);
        // findFirst() -> find the first element of the stream
        Optional<Integer>firstValue = list.stream()
                .filter(val-> val >= 3)
                .findFirst();
        System.out.println(firstValue.get());

        Optional<Integer>anyValue = list.stream()
                .filter(val->val >= 3)
                .findAny();
        System.out.println(anyValue.get());

        // Once terminal operation is used on a stream, it is closed/consumed and
        // can not be used again for another terminal operation.
        // parallel stream
        numbers = Arrays.asList(11,22,33,44,55,66,77,88,99,110);
        // sequential processing
        long sequentialProcessingStartTime = System.currentTimeMillis();
        numbers.stream()
                .map((Integer a)->a*a)
                .forEach(System.out::println);
        System.out.println("sequential processing time: "+ (System.currentTimeMillis() - sequentialProcessingStartTime)+" millisecond");

        // parallel streaming
        long parallelProcessingStartTime = System.currentTimeMillis();
        numbers.parallelStream()
                .map((Integer a)->a*a)
                .forEach(System.out::println);
        System.out.println("parallel processing time: "+ (System.currentTimeMillis() - parallelProcessingStartTime)+" millisecond");
    }

}
