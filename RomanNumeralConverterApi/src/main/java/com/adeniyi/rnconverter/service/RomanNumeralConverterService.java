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
        return null;
    }
    String getRomanHundredth(String hundredth) {
        return null;
    }

    String getRomanThousandth(String thousandth) {
        return null;
    }
}
