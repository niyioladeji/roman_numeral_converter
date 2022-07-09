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
        assertEquals(romanNumeralConverterService.getRomanUnit("0"),"");
    }
    @Test
    @DisplayName("1 (integer 1) should return I")
    void testGetRomanUnitForOne() {
        assertEquals(romanNumeralConverterService.getRomanUnit("1"),"I");
    }

    @Test
    @DisplayName("5 (integer zero) should return V")
    void testGetRomanUnitForFive() {
        assertEquals(romanNumeralConverterService.getRomanUnit("5"),"V");
    }
    @Test
    @DisplayName("2, 3, 4  should return II, III, IV respectively")
    void testGetRomanUnitForBelowFive() {
        assertEquals(romanNumeralConverterService.getRomanUnit("2"),"II");
        assertEquals(romanNumeralConverterService.getRomanUnit("3"),"III");
        assertEquals(romanNumeralConverterService.getRomanUnit("4"),"IV");
    }
    @Test
    @DisplayName("6, 7, 8 , 9 should return VI, VII, VIII, IX respectively")
    void testGetRomanUnitForAboveFive() {
        assertEquals(romanNumeralConverterService.getRomanUnit("6"),"VI");
        assertEquals(romanNumeralConverterService.getRomanUnit("7"),"VII");
        assertEquals(romanNumeralConverterService.getRomanUnit("8"),"VIII");
        assertEquals(romanNumeralConverterService.getRomanUnit("9"),"IX");
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
        assertEquals(romanNumeralConverterService.getRomanUnit("0"),"");
    }
    @Test
    void testGetRomanTenth() {
        assertEquals(romanNumeralConverterService.getRomanUnit("1"),"X");
    }
    @Test
    void testGetRomanTenthFifty() {
        assertEquals(romanNumeralConverterService.getRomanUnit("5"),"L");
    }
    @Test
    void testGetRomanTenthBelowFifty() {
        assertEquals(romanNumeralConverterService.getRomanUnit("2"),"XX");
        assertEquals(romanNumeralConverterService.getRomanUnit("3"),"XXX");
        assertEquals(romanNumeralConverterService.getRomanUnit("4"),"XL");
    }
    @Test
    void testGetRomanTenthAboveFifty() {
        assertEquals(romanNumeralConverterService.getRomanUnit("6"),"LX");
        assertEquals(romanNumeralConverterService.getRomanUnit("7"),"LXX");
        assertEquals(romanNumeralConverterService.getRomanUnit("8"),"LXXX");
        assertEquals(romanNumeralConverterService.getRomanUnit("9"),"XC");
    }
    @Test
    void testGetRomanHundredth() {
        fail("Test not written");
    }
    @Test
    void testGetRomanFiveHundredth() {
        fail("Test not written");
    }
    @Test
    void testGetRomanHundredthBelowFiveHundred() {
        fail("Test not written");
    }
    @Test
    void testGetRomanHundredthAboveFiveHundred() {
        fail("Test not written");
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
