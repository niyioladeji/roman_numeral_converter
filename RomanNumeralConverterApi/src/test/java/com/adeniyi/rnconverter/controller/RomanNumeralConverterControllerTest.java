package com.adeniyi.rnconverter.controller;

import com.adeniyi.rnconverter.dto.RomanNumeralToArabicNumberDto;
import com.adeniyi.rnconverter.service.RomanNumeralConverterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RomanNumeralConverterControllerTest {
    static final String INVALID_ROMAN_NUMERAL_MSG =
            "Roman Numeral cannot be generated for the provided number";
    @InjectMocks
    private RomanNumeralConverterController rmConverterController;
    @Spy
    private RomanNumeralConverterService romanNumeralConverterService;

    @Test
    void testGetRomanNumeralForOutOfRange() {
        ResponseEntity responseEntity = rmConverterController.getRomanNumeral(-1);
        assertEquals(responseEntity.getStatusCodeValue(), 400);
        assertEquals(responseEntity.getBody().toString(), INVALID_ROMAN_NUMERAL_MSG);
        responseEntity = rmConverterController.getRomanNumeral(3001);
        assertEquals(responseEntity.getStatusCodeValue(), 400);
        assertEquals(responseEntity.getBody().toString(), INVALID_ROMAN_NUMERAL_MSG);
        responseEntity = rmConverterController.getRomanNumeral(0);
        assertEquals(responseEntity.getStatusCodeValue(), 400);
        assertEquals(responseEntity.getBody().toString(), INVALID_ROMAN_NUMERAL_MSG);

    }

    @Test
    void testGetRomanNumeralSmallInteger() {
        ResponseEntity responseEntity = rmConverterController.getRomanNumeral(10);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(romanNumeralToArabicNumberDto.getRomanNumeral(), "X");
        responseEntity = rmConverterController.getRomanNumeral(7);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(romanNumeralToArabicNumberDto.getRomanNumeral(), "VII");
        responseEntity = rmConverterController.getRomanNumeral(65);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(romanNumeralToArabicNumberDto.getRomanNumeral(), "LXV");
    }

    @Test
    void testGetRomanNumeralForHundredths() {
        ResponseEntity responseEntity = rmConverterController.getRomanNumeral(100);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(romanNumeralToArabicNumberDto.getRomanNumeral(), "C");
        responseEntity = rmConverterController.getRomanNumeral(207);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(romanNumeralToArabicNumberDto.getRomanNumeral(), "CCVII");
        responseEntity = rmConverterController.getRomanNumeral(865);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(romanNumeralToArabicNumberDto.getRomanNumeral(), "DCCCLXV");
    }

    @Test
    void testGetRomanNumeralForThousandths() {
        ResponseEntity responseEntity = rmConverterController.getRomanNumeral(1110);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(romanNumeralToArabicNumberDto.getRomanNumeral(), "MCX");
        responseEntity = rmConverterController.getRomanNumeral(2207);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(romanNumeralToArabicNumberDto.getRomanNumeral(), "MMCCVII");
        responseEntity = rmConverterController.getRomanNumeral(1865);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(romanNumeralToArabicNumberDto.getRomanNumeral(), "MDCCCLXV");
    }


}
