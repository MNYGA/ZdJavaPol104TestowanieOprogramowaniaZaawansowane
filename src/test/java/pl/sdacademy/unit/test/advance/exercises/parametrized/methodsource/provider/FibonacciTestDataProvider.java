package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class FibonacciTestDataProvider {

    public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(4, 3),
                Arguments.of(6, 8),
                Arguments.of(8, 21)
        );
    }
}
