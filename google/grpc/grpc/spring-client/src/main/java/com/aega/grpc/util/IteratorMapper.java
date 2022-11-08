package com.aega.grpc.util;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

 
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IteratorMapper {

    // Function to get the Stream
    public static <T> Stream<T> getStream(Iterator<T> iterator) {
        // Convert the iterator to Spliterator
        Spliterator<T> spliterator = Spliterators
            .spliteratorUnknownSize(iterator, 0);

        // Get a Sequential Stream from spliterator
        return StreamSupport.stream(spliterator, false);
    }

}
