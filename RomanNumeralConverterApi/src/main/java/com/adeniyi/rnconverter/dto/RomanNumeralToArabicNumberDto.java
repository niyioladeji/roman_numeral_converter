package com.adeniyi.rnconverter.dto;

/**
 *
 * The RomanNumeralToArabicNumberDto is a dto for integer and roman numeral pair.
 * The dto is used as part of API response data for roman numeral restful service.
 *
 * @author  Adeniyi Oladeji
 * @version 0.0.1
 * @since   2022-07-11
 */
public class RomanNumeralToArabicNumberDto {
    private int arabicNumber;
    private String RomanNumeral;

    public int getArabicNumber() {
        return arabicNumber;
    }

    public void setArabicNumber(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    public String getRomanNumeral() {
        return RomanNumeral;
    }

    public void setRomanNumeral(String romanNumeral) {
        RomanNumeral = romanNumeral;
    }
}
