package number.convrter;

import java.util.Map;
import java.util.TreeMap;

public class DecimalToRomanConverter {

    private Map<Integer, String> decimalToRomanMap;

    public DecimalToRomanConverter() {
        decimalToRomanMap = new TreeMap<>();
        decimalToRomanMap.put(1, "I");
        decimalToRomanMap.put(4, "IV");
        decimalToRomanMap.put(5, "V");
        decimalToRomanMap.put(9, "IX");
        decimalToRomanMap.put(10, "X");
        decimalToRomanMap.put(40, "XL");
        decimalToRomanMap.put(50, "L");
        decimalToRomanMap.put(90, "XC");
        decimalToRomanMap.put(100, "C");
        decimalToRomanMap.put(400, "CD");
        decimalToRomanMap.put(500, "D");
        decimalToRomanMap.put(900, "CM");
        decimalToRomanMap.put(1000, "M");
    }

    public String convertToRomanNumber(int decimalNumberToConvert) {
        StringBuilder result = new StringBuilder();

        while (decimalNumberToConvert != 0) {

            String romanDigits = getRomanDigits(decimalNumberToConvert, 1);
            int length = String.valueOf(decimalNumberToConvert).length();
            int pow = (int) Math.pow(10d, length - 1);

            if (romanDigits.isEmpty()) {

                int d = decimalNumberToConvert / pow;

                if (d >= 9 && !getRomanDigits(9 * pow, 1).isEmpty()) {
                    romanDigits = getRomanDigits(9 * pow, 1);
                    decimalNumberToConvert -= 9 * pow;
                } else if (d >= 5 && !getRomanDigits(5 * pow, 1).isEmpty()) {
                    romanDigits = getRomanDigits(5 * pow, 1);
                    decimalNumberToConvert -= 5 * pow;
                } else if (!getRomanDigits(pow * d, 1).isEmpty()) {
                    romanDigits = getRomanDigits(pow * d, 1);
                    decimalNumberToConvert = decimalNumberToConvert % pow;
                } else {
                    romanDigits = getRomanDigits(pow, d);
                    decimalNumberToConvert = decimalNumberToConvert % pow;
                }
            } else {
                decimalNumberToConvert = decimalNumberToConvert % pow;
            }

            result.append(romanDigits);
        }
        return result.toString();
    }

    private String getRomanDigits(int decimalNumber, int rep) {

        String romanSymbol = decimalToRomanMap.get(decimalNumber);
        StringBuilder result = new StringBuilder();
        if (romanSymbol != null) {
            for (int i = 0; i < rep; i++) {
                result.append(romanSymbol);
            }
        }
        return result.toString();
    }
}
