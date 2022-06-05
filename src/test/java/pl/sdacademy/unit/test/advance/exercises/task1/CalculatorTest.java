package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("dataProviderForMultiply")
    void shouldMultiplyTwoDigits(int firstDigit, int secondDigit, int expectedResult) {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.multiply(firstDigit, secondDigit);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    private static Stream<Arguments> dataProviderForMultiply() {
        return Stream.of(
                Arguments.of(2, 3, 6),
                Arguments.of(4, 3, 12),
                Arguments.of(0, 3, 0)
        );
    }

}