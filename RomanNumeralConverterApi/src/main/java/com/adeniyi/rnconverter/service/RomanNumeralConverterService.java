package com.adeniyi.rnconverter.service;

public class RomanNumeralConverterService {

    public String getRomanNumeralForInteger(int unit) {
        return null;
    }
    String getRomanUnit(String unitCharacter) {
        if (unitCharacter==null) {
            throw new IllegalArgumentException ("Number can't be null");
        }
        if (unitCharacter.length()!=1) {
            throw new IllegalArgumentException ("Number length must be 1");
        }
        return null;
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
