package com.adeniyi.rnconverter.service;

public class RomanNumeralConverterService {
    private static final String NULL_NUMBER_EXCEPTION = "Number can't be null";
    private static final String INVALID_NUMBER_EXCEPTION = "Number length must be 0 - 9";

    public String getRomanNumeralForInteger(int unit) {
        return null;
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
        return null;
    }
}
