package com.softdevco;

import java.util.stream.IntStream;

public class Main {
    /**
     * stepic streams task1 method
     * @param seed int to start with
     * @return int stream
     */
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n->n*n/10%1000);
    }

}
