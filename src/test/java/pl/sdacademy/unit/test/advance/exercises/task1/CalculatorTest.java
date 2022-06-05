package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @MethodSource("dataProviderForMultiply")
    void shouldMultiplyTwoDigits(int firstDigit, int secondDigit, int expectedResult) {
        //given
        //when
        int result = calculator.multiply(firstDigit, secondDigit);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    @Test
    void shouldThrowExceptionWhenSecondDigitIsEqualToZero() {
        //given
        int firstDigit = 5;
        int secondDigit = 0;
        //when & then
        //junit
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(firstDigit, secondDigit));
        //assertJ
        assertThatThrownBy(() ->calculator.divide(firstDigit, secondDigit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can't divide by 0!");
    }

    private static Stream<Arguments> dataProviderForMultiply() {
        return Stream.of(
                Arguments.of(2, 3, 6),
                Arguments.of(4, 3, 12),
                Arguments.of(0, 3, 0)
        );
    }

}