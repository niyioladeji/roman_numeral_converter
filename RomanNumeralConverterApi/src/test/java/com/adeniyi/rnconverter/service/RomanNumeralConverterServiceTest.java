package com.adeniyi.rnconverter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RomanNumeralConverterServiceTest {

    private RomanNumeralConverterService romanNumeralConverterService;

    @BeforeEach
    void setUp() {
        romanNumeralConverterService =
                new RomanNumeralConverterService();
    }

    @Test
    void testGetRomanNumeralForInteger() {
        fail("PlaceHolder test");
    }
    @Test
    @DisplayName("null should throw exception")
    void testGetRomanUnitForNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanUnit(null));
        assertEquals("Number can't be null", exception.getMessage());
    }
    @Test
    @DisplayName("test values outside 0 - 9")
    void testGetRomanUnitForNonSingularString() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanUnit("11"));
        assertEquals("Number length must be 0 - 9", exception.getMessage());
    }
    @Test
    @DisplayName("0 (integer zero) should return empty string")
    void testGetRomanUnitForZero() {
        assertEquals("", romanNumeralConverterService.getRomanUnit("0"));
    }
    @Test
    @DisplayName("1 (integer 1) should return I")
    void testGetRomanUnitForOne() {
        assertEquals("I", romanNumeralConverterService.getRomanUnit("1"));
    }

    @Test
    @DisplayName("5 (integer zero) should return V")
    void testGetRomanUnitForFive() {
        assertEquals("V", romanNumeralConverterService.getRomanUnit("5"));
    }
    @Test
    @DisplayName("2, 3, 4  should return II, III, IV respectively")
    void testGetRomanUnitForBelowFive() {
        assertEquals("II", romanNumeralConverterService.getRomanUnit("2"));
        assertEquals("III", romanNumeralConverterService.getRomanUnit("3"));
        assertEquals("IV", romanNumeralConverterService.getRomanUnit("4"));
    }
    @Test
    @DisplayName("6, 7, 8 , 9 should return VI, VII, VIII, IX respectively")
    void testGetRomanUnitForAboveFive() {
        assertEquals("VI", romanNumeralConverterService.getRomanUnit("6"));
        assertEquals("VII", romanNumeralConverterService.getRomanUnit("7"));
        assertEquals("VIII", romanNumeralConverterService.getRomanUnit("8"));
        assertEquals("IX", romanNumeralConverterService.getRomanUnit("9"));
    }
    @Test
    @DisplayName("test values that is null OR outside of 0 - 9")
    void testInvalidGetRomanTenth() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanTenth(null));
        assertEquals("Number can't be null", exception.getMessage());
        Throwable exception1 = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanTenth("11"));
        assertEquals("Number length must be 0 - 9", exception1.getMessage());
    }
    @Test
    void testGetZeroRomanTenth() {
        assertEquals("", romanNumeralConverterService.getRomanTenth("0"));
    }
    @Test
    void testGetRomanTenth() {
        assertEquals("X", romanNumeralConverterService.getRomanTenth("1"));
    }
    @Test
    void testGetRomanTenthFifty() {
        assertEquals("L", romanNumeralConverterService.getRomanTenth("5"));
    }
    @Test
    void testGetRomanTenthBelowFifty() {
        assertEquals("XX", romanNumeralConverterService.getRomanTenth("2"));
        assertEquals("XXX", romanNumeralConverterService.getRomanTenth("3"));
        assertEquals("XL", romanNumeralConverterService.getRomanTenth("4"));
    }
    @Test
    void testGetRomanTenthAboveFifty() {
        assertEquals("LX", romanNumeralConverterService.getRomanTenth("6"));
        assertEquals("LXX", romanNumeralConverterService.getRomanTenth("7"));
        assertEquals("LXXX", romanNumeralConverterService.getRomanTenth("8"));
        assertEquals("XC", romanNumeralConverterService.getRomanTenth("9"));
    }
    @Test
    @DisplayName("test values that is null OR outside of 0 - 9")
    void testInvalidGetRomanHundredth() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanHundredth(null));
        assertEquals("Number can't be null", exception.getMessage());
        Throwable exception1 = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanHundredth("11"));
        assertEquals("Number value must be 0 - 9", exception1.getMessage());
    }
    @Test
    void testGetZeroRomanHundredth() {
        assertEquals("", romanNumeralConverterService.getRomanHundredth("0"));
    }
    @Test
    void testGetRomanHundredth() {
        assertEquals("C", romanNumeralConverterService.getRomanHundredth("1"));
    }
    @Test
    void testGetRomanFiveHundredth() {
        assertEquals("D", romanNumeralConverterService.getRomanHundredth("5"));
    }
    @Test
    void testGetRomanHundredthBelowFiveHundred() {
        assertEquals("CC", romanNumeralConverterService.getRomanHundredth("2"));
        assertEquals("CCC", romanNumeralConverterService.getRomanHundredth("3"));
        assertEquals("CD", romanNumeralConverterService.getRomanHundredth("4"));
    }
    @Test
    void testGetRomanHundredthAboveFiveHundred() {
        assertEquals("DC", romanNumeralConverterService.getRomanHundredth("6"));
        assertEquals("DCC", romanNumeralConverterService.getRomanHundredth("7"));
        assertEquals("DCCC", romanNumeralConverterService.getRomanHundredth("8"));
        assertEquals("CM", romanNumeralConverterService.getRomanHundredth("9"));
    }
    @Test
    void testGetRomanThousandth() {
        fail("Test not written");
    }
    @Test
    void testGetRomanThreeThousandth() {
        fail("Test not written");
    }
    @Test
    void testGetRomanAboveThreeThousandth() {
        fail("Test not written");
    }
    @Test
    void testGetRomanBelowThreeThousandth() {
        fail("Test not written");
    }

}
