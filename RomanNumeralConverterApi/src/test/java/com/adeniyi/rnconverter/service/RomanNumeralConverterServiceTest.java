package com.adeniyi.rnconverter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RomanNumeralConverterServiceTest {

    private RomanNumeralConverterService romanNumeralConverterService;
    static final String INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG =
            "Invalid Roman numeral. Cannot convert to integer";

    @BeforeEach
    void setUp() {
        romanNumeralConverterService =
                new RomanNumeralConverterService();
    }

    @Test
    void testGetIntegerFromRomanNumeralOutOfRange() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getIntegerFromRomanNumeral("XXXX"));
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getIntegerFromRomanNumeral("CCCLC"));
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getIntegerFromRomanNumeral("CCCIC"));
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getIntegerFromRomanNumeral("CCCC"));
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getIntegerFromRomanNumeral("XXXCC"));
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getIntegerFromRomanNumeral("IIXX"));
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getIntegerFromRomanNumeral("MMIIXX"));
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, exception.getMessage());
    }

    @Test
    void testGetIntegerFromRomanNumeralSmall() {
        assertEquals(14, romanNumeralConverterService.getIntegerFromRomanNumeral("XIV"));
        assertEquals(20, romanNumeralConverterService.getIntegerFromRomanNumeral("XX"));
        assertEquals(8, romanNumeralConverterService.getIntegerFromRomanNumeral("VIII"));
        assertEquals(4, romanNumeralConverterService.getIntegerFromRomanNumeral("IV"));
        assertEquals(79, romanNumeralConverterService.getIntegerFromRomanNumeral("LXXIX"));
        assertEquals(84, romanNumeralConverterService.getIntegerFromRomanNumeral("LXXXIV"));
        assertEquals(94, romanNumeralConverterService.getIntegerFromRomanNumeral("XCIV"));
        assertEquals(69, romanNumeralConverterService.getIntegerFromRomanNumeral("LXIX"));
    }

    @Test
    void testGetIntegerFromRomanNumeralHundredth() {
        assertEquals(114, romanNumeralConverterService.getIntegerFromRomanNumeral("CXIV"));
        assertEquals(320, romanNumeralConverterService.getIntegerFromRomanNumeral("CCCXX"));
        assertEquals(408, romanNumeralConverterService.getIntegerFromRomanNumeral("CDVIII"));
        assertEquals(504, romanNumeralConverterService.getIntegerFromRomanNumeral("DIV"));
        assertEquals(979, romanNumeralConverterService.getIntegerFromRomanNumeral("CMLXXIX"));
        assertEquals(884, romanNumeralConverterService.getIntegerFromRomanNumeral("DCCCLXXXIV"));
        assertEquals(994, romanNumeralConverterService.getIntegerFromRomanNumeral("CMXCIV"));
        assertEquals(769, romanNumeralConverterService.getIntegerFromRomanNumeral("DCCLXIX"));
    }

    @Test
    void testGetIntegerFromRomanNumeralThousandth() {
        assertEquals(1114, romanNumeralConverterService.getIntegerFromRomanNumeral("MCXIV"));
        assertEquals(2320, romanNumeralConverterService.getIntegerFromRomanNumeral("MMCCCXX"));
        assertEquals(1408, romanNumeralConverterService.getIntegerFromRomanNumeral("MCDVIII"));
        assertEquals(3504, romanNumeralConverterService.getIntegerFromRomanNumeral("MMMDIV"));
        assertEquals(3979, romanNumeralConverterService.getIntegerFromRomanNumeral("MMMCMLXXIX"));
        assertEquals(3884, romanNumeralConverterService.getIntegerFromRomanNumeral("MMMDCCCLXXXIV"));
        assertEquals(1994, romanNumeralConverterService.getIntegerFromRomanNumeral("MCMXCIV"));
        assertEquals(2769, romanNumeralConverterService.getIntegerFromRomanNumeral("MMDCCLXIX"));
    }

    @Test
    @DisplayName("Test case to check if string contains 4 consecutive characters")
    void testIfStringContainsFourConsecutiveCharacters() {
        assertTrue(
                romanNumeralConverterService.containsFourConsecutiveCharacters("XXXX"));
        assertTrue(
                romanNumeralConverterService.containsFourConsecutiveCharacters("CCDDDDEF"));
        assertTrue(
                romanNumeralConverterService.containsFourConsecutiveCharacters("CCDDDDDEF"));
        assertFalse(
                romanNumeralConverterService.containsFourConsecutiveCharacters("ABCDEFGH"));
        assertFalse(
                romanNumeralConverterService.containsFourConsecutiveCharacters("CCC"));
        assertFalse(
                romanNumeralConverterService.containsFourConsecutiveCharacters("ABCCCDDEF"));
    }


    @Test
    void testGetRomanNumeralForOutOfRangeInteger() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanNumeralForInteger(-1));
        assertEquals("Number out of range. Can only convert 1 - 3000", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanNumeralForInteger(0));
        assertEquals("Number out of range. Can only convert 1 - 3000", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanNumeralForInteger(-100));
        assertEquals("Number out of range. Can only convert 1 - 3000", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanNumeralForInteger(-100));
        assertEquals("Number out of range. Can only convert 1 - 3000", exception.getMessage());
    }
    @Test
    void testGetRomanNumeralForIntegerEndsWithZero() {
        assertEquals("X", romanNumeralConverterService.getRomanNumeralForInteger(10));
        assertEquals("XX", romanNumeralConverterService.getRomanNumeralForInteger(20));
        assertEquals("XXX", romanNumeralConverterService.getRomanNumeralForInteger(30));
        assertEquals("XL", romanNumeralConverterService.getRomanNumeralForInteger(40));
        assertEquals("L", romanNumeralConverterService.getRomanNumeralForInteger(50));
        assertEquals("LX", romanNumeralConverterService.getRomanNumeralForInteger(60));
        assertEquals("LXX", romanNumeralConverterService.getRomanNumeralForInteger(70));
        assertEquals("LXXX", romanNumeralConverterService.getRomanNumeralForInteger(80));
        assertEquals("XC", romanNumeralConverterService.getRomanNumeralForInteger(90));
        assertEquals("C", romanNumeralConverterService.getRomanNumeralForInteger(100));
        assertEquals("CXX", romanNumeralConverterService.getRomanNumeralForInteger(120));
        assertEquals("CXL", romanNumeralConverterService.getRomanNumeralForInteger(140));
        assertEquals("CCC", romanNumeralConverterService.getRomanNumeralForInteger(300));
        assertEquals("CDL", romanNumeralConverterService.getRomanNumeralForInteger(450));
        assertEquals("CDXL", romanNumeralConverterService.getRomanNumeralForInteger(440));
        assertEquals("MMDCCCL", romanNumeralConverterService.getRomanNumeralForInteger(2850));
        assertEquals("MMM", romanNumeralConverterService.getRomanNumeralForInteger(3000));
    }
    @Test
    void testGetRomanNumeralForIntegerSingular() {
        assertEquals("I", romanNumeralConverterService.getRomanNumeralForInteger(1));
        assertEquals("II", romanNumeralConverterService.getRomanNumeralForInteger(2));
        assertEquals("III", romanNumeralConverterService.getRomanNumeralForInteger(3));
        assertEquals("IV", romanNumeralConverterService.getRomanNumeralForInteger(4));
        assertEquals("V", romanNumeralConverterService.getRomanNumeralForInteger(5));
        assertEquals("VI", romanNumeralConverterService.getRomanNumeralForInteger(6));
        assertEquals("VII", romanNumeralConverterService.getRomanNumeralForInteger(7));
        assertEquals("VIII", romanNumeralConverterService.getRomanNumeralForInteger(8));
        assertEquals("IX", romanNumeralConverterService.getRomanNumeralForInteger(9));
    }
    @Test
    void testGetRomanNumeralForIntegerTens() {
        assertEquals("XI", romanNumeralConverterService.getRomanNumeralForInteger(11));
        assertEquals("XXV", romanNumeralConverterService.getRomanNumeralForInteger(25));
        assertEquals("LXVI", romanNumeralConverterService.getRomanNumeralForInteger(66));
        assertEquals("LXXVIII", romanNumeralConverterService.getRomanNumeralForInteger(78));
        assertEquals("LXXXV", romanNumeralConverterService.getRomanNumeralForInteger(85));
        assertEquals("XCII", romanNumeralConverterService.getRomanNumeralForInteger(92));
    }
    @Test
    void testGetRomanNumeralForIntegerHundreds() {
        assertEquals("CXI", romanNumeralConverterService.getRomanNumeralForInteger(111));
        assertEquals("CCXXV", romanNumeralConverterService.getRomanNumeralForInteger(225));
        assertEquals("CDLXVI", romanNumeralConverterService.getRomanNumeralForInteger(466));
        assertEquals("CMLXXVIII", romanNumeralConverterService.getRomanNumeralForInteger(978));
        assertEquals("DCCLXXXV", romanNumeralConverterService.getRomanNumeralForInteger(785));
        assertEquals("DCXCII", romanNumeralConverterService.getRomanNumeralForInteger(692));
    }
    @Test
    void testGetRomanNumeralForIntegerThousands() {
        assertEquals("MCXI", romanNumeralConverterService.getRomanNumeralForInteger(1111));
        assertEquals("MCCXXV", romanNumeralConverterService.getRomanNumeralForInteger(1225));
        assertEquals("MMCDLXVI", romanNumeralConverterService.getRomanNumeralForInteger(2466));
        assertEquals("MMCMLXXVIII", romanNumeralConverterService.getRomanNumeralForInteger(2978));
        assertEquals("MDCCLXXXV", romanNumeralConverterService.getRomanNumeralForInteger(1785));
        assertEquals("MMDCXCII", romanNumeralConverterService.getRomanNumeralForInteger(2692));
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
        assertEquals("Number value must be 0 - 9", exception.getMessage());
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
        assertEquals("Number value must be 0 - 9", exception1.getMessage());
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
    void testGetZeroRomanThousandth() {
        assertEquals("", romanNumeralConverterService.getRomanThousandth("0"));
    }
    @Test
    void testGetRomanThousandth() {
        assertEquals("M", romanNumeralConverterService.getRomanThousandth("1"));
    }
    @Test
    void testGetRomanTwoThousandth() {
        assertEquals("MM", romanNumeralConverterService.getRomanThousandth("2"));
    }
    @Test
    void testGetRomanThreeThousandth() {
        assertEquals("MMM", romanNumeralConverterService.getRomanThousandth("3"));
    }
    @Test
    @DisplayName("test values that is null OR outside of 0 - 9")
    void testInvalidGetRomanThousandth() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanThousandth(null));
        assertEquals("Number can't be null", exception.getMessage());
        Throwable exception1 = assertThrows(IllegalArgumentException.class,
                () -> romanNumeralConverterService.getRomanThousandth("4"));
        assertEquals("Number value must be 1 - 3", exception1.getMessage());
    }

}
