package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    /*
    true:
    kajak
    kobyla ma maly bok
    sedes

    false:
    java
    programowanie
     */

    /*
    na potrzeby nauki zrobiliśmy jedną wspólną metodę testową, natomiast
    normalnie powinniśmy rozbić to na dwie: dla true i false
     */
    @ParameterizedTest
    @CsvSource({"kajak, true",
                "kobyla ma maly bok, true",
                "sedes, true",
                "java, false",
                "programowanie, false"})
    void shouldVerifyIfStringIsPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv",
                   delimiter = '|')
    void shouldVerifyIfStringIsPalindrome_CsvFileSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }
}