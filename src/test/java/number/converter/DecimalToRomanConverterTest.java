package number.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalToRomanConverterTest {

    private DecimalToRomanConverter decimalToRomanConverter;

    @BeforeEach
    void setUp() {
        decimalToRomanConverter = new DecimalToRomanConverter();
    }

    @ParameterizedTest
    @MethodSource({"provideCompleteTestDataSet", "provideInitialTestData"})
    public void testDecimalToRomanConverter(int decimalNumber, String romanNumber) {

        String result = decimalToRomanConverter.convertToRomanNumber(decimalNumber);
        assertEquals(romanNumber, result);
        System.out.println(decimalNumber + " decimal --> roman " + result);
    }

    private static Stream<Arguments> provideInitialTestData() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(4, "IV"),
                Arguments.of(5, "V"),
                Arguments.of(9, "IX"),
                Arguments.of(10, "X"),
                Arguments.of(40, "XL"),
                Arguments.of(50, "L"),
                Arguments.of(90, "XC"),
                Arguments.of(100, "C"),
                Arguments.of(400, "CD"),
                Arguments.of(500, "D"),
                Arguments.of(900, "CM"),
                Arguments.of(1000, "M")
        );
    }

    private static Collection provideCompleteTestDataSet() {
        return Arrays.asList(
                new Object[][]{
                        {1, "I"},
                        {2, "II"},
                        {4, "IV"},
                        {5, "V"},
                        {6, "VI"},
                        {9, "IX"},
                        {10, "X"},
                        {11, "XI"},
                        {14, "XIV"},
                        {15, "XV"},
                        {16, "XVI"},
                        {20, "XX"},
                        {30, "XXX"},
                        {49, "XLIX"},
                        {50, "L"},
                        {51, "LI"},
                        {55, "LV"},
                        {60, "LX"},
                        {80, "LXXX"},
                        {91, "XCI"},
                        {98, "XCVIII"},
                        {101, "CI"},
                        {198, "CXCVIII"},
                        {199, "CXCIX"},
                        {246, "CCXLVI"},
                        {489, "CDLXXXIX"},
                        {499, "CDXCIX"},
                        {541, "DXLI"},
                        {900, "CM"},
                        {950, "CML"},
                        {994, "CMXCIV"},
                        {995, "CMXCV"},
                        {999, "CMXCIX"},
                        {1999, "MCMXCIX"},
                        {2198, "MMCXCVIII"},
                        {3549, "MMMDXLIX"},
                        {9000, "MMMMMMMMM"},
                        {9999, "MMMMMMMMMCMXCIX"}

                });
    }
}