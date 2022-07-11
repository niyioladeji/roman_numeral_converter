package com.adeniyi.rnconverter.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * The RomanNumeralConverterService provides simple interfaces for converting
 * integer to and from roman numeral number notations.
 *
 * Suitable for
 *      -   converting integers between 1 - 3000 to roman numeral string
 *      -   converting any valid roman numeral string to an integer
 *
 * @author  Adeniyi Oladeji
 * @version 0.0.1
 * @since   2022-07-11
 */
@Service
public class RomanNumeralConverterService {
    private static final String NULL_NUMBER_EXCEPTION = "Number can't be null";
    private static final String INVALID_NUMBER_EXCEPTION = "Number value must be 0 - 9";
    private static final String THOUSANDTH_INVALID_NUMBER_EXCEPTION = "Number value must be 1 - 3";
    private static final String INVALID_NUMBER_RANGE_EXCEPTION = "Number out of range. Can only convert 1 - 3000";
    private static final String INVALID_ROMAN_NUMERAL_EXCEPTION = "Invalid Roman numeral. Cannot convert to integer";

    private static final Map<String,Integer> romanSymbolToIntegerMap =
            new HashMap<>();
    static {
        romanSymbolToIntegerMap.put("I", 1);
        romanSymbolToIntegerMap.put("V", 5);
        romanSymbolToIntegerMap.put("X", 10);
        romanSymbolToIntegerMap.put("L", 50);
        romanSymbolToIntegerMap.put("C", 100);
        romanSymbolToIntegerMap.put("D", 500);
        romanSymbolToIntegerMap.put("M", 1000);
    }

    /**
     * @param romanNumeral
     *      Roman Numeral to be converted
     * @return
     *      Integer value equivalent
     * @throws IllegalArgumentException
     *      For any invalid Roman numeral input parameter
     */
    public int getIntegerFromRomanNumeral(String romanNumeral)  throws IllegalArgumentException {
        int intValueOfRomanNumeral = 0;
        String [] romanNumeralCharacters = romanNumeral.split("");
        for (int pos=0; pos < romanNumeralCharacters.length; pos++ ) {
            if (pos > 1 && (romanSymbolToIntegerMap.get(romanNumeralCharacters[pos])>
                    romanSymbolToIntegerMap.get(romanNumeralCharacters[pos-2]))) {
                throw new IllegalArgumentException (INVALID_ROMAN_NUMERAL_EXCEPTION);
            }

            if (pos > 0 && (romanSymbolToIntegerMap.get(romanNumeralCharacters[pos])>
                    romanSymbolToIntegerMap.get(romanNumeralCharacters[pos-1]))) {
                intValueOfRomanNumeral +=
                        (romanSymbolToIntegerMap.get(romanNumeralCharacters[pos])
                        - (2*romanSymbolToIntegerMap.get(romanNumeralCharacters[pos-1])));
            }
            else{
                intValueOfRomanNumeral += romanSymbolToIntegerMap.get(romanNumeralCharacters[pos]);
            }
        }
        return intValueOfRomanNumeral;
    }

    boolean containsFourConsecutiveCharacters(String word) {

        return false;
    }

    /**
     * Converts any integer between 1 and 3000 to roman numeral
     * @param unit
     *      Integer unit to be converted
     * @return
     *      Roman numeral equivalent
     * @throws IllegalArgumentException
     *      For any integer input parameter not between 1 and 3000
     */
    public String getRomanNumeralForInteger(int unit) throws IllegalArgumentException {
        if (unit < 1 || unit > 3000) {
            throw new IllegalArgumentException (INVALID_NUMBER_RANGE_EXCEPTION);
        }
        String inputValue = StringUtils.leftPad(Integer.toString(unit),4,"0");
        String [] value = inputValue.split("");
        StringBuilder romanNumeral = new StringBuilder();
        for (int i = 0 ; i < value.length; i++) {
            String valueOfIndex = value[i];
            switch (i) {
                case 0 -> romanNumeral.append(getRomanThousandth(valueOfIndex));
                case 1 -> romanNumeral.append(getRomanHundredth(valueOfIndex));
                case 2 -> romanNumeral.append(getRomanTenth(valueOfIndex));
                case 3 -> romanNumeral.append(getRomanUnit(valueOfIndex));
            }
        }
        return romanNumeral.toString();
    }

    String getRomanUnit(String unitCharacter) {
        if (unitCharacter==null) {
            throw new IllegalArgumentException (NULL_NUMBER_EXCEPTION);
        }
        return  switch (unitCharacter) {
            case "0"-> "";
            case "1"-> "I";
            case "2"->"II";
            case "3"->"III";
            case "4"->"IV";
            case "5"-> "V";
            case "6"-> "VI";
            case "7"->"VII";
            case "8"-> "VIII";
            case "9"-> "IX";
            default->throw new IllegalArgumentException (INVALID_NUMBER_EXCEPTION);
        };
    }
    String getRomanTenth(String tens) {
        if (tens==null) {
            throw new IllegalArgumentException (NULL_NUMBER_EXCEPTION);
        }
        return  switch (tens) {
            case "0"-> "";
            case "1"-> "X";
            case "2"-> "XX";
            case "3"-> "XXX";
            case "4"-> "XL";
            case "5"-> "L";
            case "6"-> "LX";
            case "7"-> "LXX";
            case "8"-> "LXXX";
            case "9"-> "XC";
            default->throw new IllegalArgumentException (INVALID_NUMBER_EXCEPTION);
        };
    }
    String getRomanHundredth(String hundredth) {
        if (hundredth==null) {
            throw new IllegalArgumentException (NULL_NUMBER_EXCEPTION);
        }
        return  switch (hundredth) {
            case "0"-> "";
            case "1"-> "C";
            case "2"-> "CC";
            case "3"-> "CCC";
            case "4"-> "CD";
            case "5"-> "D";
            case "6"-> "DC";
            case "7"-> "DCC";
            case "8"-> "DCCC";
            case "9"-> "CM";
            default->throw new IllegalArgumentException (INVALID_NUMBER_EXCEPTION);
        };
    }

    String getRomanThousandth(String thousandth) {
        if (thousandth==null) {
            throw new IllegalArgumentException (NULL_NUMBER_EXCEPTION);
        }
        return  switch (thousandth) {
            case "0"-> "";
            case "1"-> "M";
            case "2"-> "MM";
            case "3"-> "MMM";
            default->throw new IllegalArgumentException (THOUSANDTH_INVALID_NUMBER_EXCEPTION);
        };
    }
}
