package com.adeniyi.rnconverter.service;

public class RomanNumeralConverterService {

    public String getRomanNumeralForInteger(int unit) {
        return null;
    }
    String getRomanUnit(String unitCharacter) {
        if (unitCharacter==null) {
            throw new IllegalArgumentException ("Number can't be null");
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
            default->throw new IllegalArgumentException ("Number length must be 0 - 9");
        };
    }
    String getRomanTenth(String tens) {
        if (tens==null) {
            throw new IllegalArgumentException ("Number can't be null");
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
            default->throw new IllegalArgumentException ("Number length must be 0 - 9");
        };
    }
    String getRomanHundredth(String hundredth) {
        return null;
    }

    String getRomanThousandth(String thousandth) {
        return null;
    }
}
