package org.example;

import com.java8.factory.InstituteFactory;
import com.java8.factory.StudentFactory;

import java.util.List;
import java.util.stream.Collectors;

/*Java 8 map() operation takes Stream of type T as input and produces a result Stream of type R.
It applies given mapper function to each element of
input Stream<T> and results are stored in an output Stream<R>.


flatMap() operation takes Stream<Stream<T> as input and produces a result Stream of type R.
It’s mapper function produces multiple values
 for each value of input stream and those multiple values are flattened into a result Stream<R>.

 */
public class StreamMapAndFlatMap {

    public static void main(String[] args) {

        InstituteFactory instituteFactory = new InstituteFactory();

     List<String> collect = instituteFactory.getInstituteList().stream().map(institute -> {
            return institute.getName();
        }).collect(Collectors.toUnmodifiableList());

    System.out.println(collect);



    }
}
