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
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_MSG, responseEntity.getBody().toString());
        responseEntity = rmConverterController.getRomanNumeral(3001);
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_MSG, responseEntity.getBody().toString());
        responseEntity = rmConverterController.getRomanNumeral(0);
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_MSG, responseEntity.getBody().toString());

    }

    @Test
    void testGetRomanNumeralSmallInteger() {
        ResponseEntity responseEntity = rmConverterController.getRomanNumeral(10);
        assertEquals(200, responseEntity.getStatusCodeValue());
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals("X", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getRomanNumeral(7);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("VII", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getRomanNumeral(65);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("LXV", romanNumeralToArabicNumberDto.getRomanNumeral());
    }

    @Test
    void testGetRomanNumeralForHundredths() {
        ResponseEntity responseEntity = rmConverterController.getRomanNumeral(100);
        assertEquals(200, responseEntity.getStatusCodeValue());
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals("C", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getRomanNumeral(207);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("CCVII", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getRomanNumeral(865);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("DCCCLXV", romanNumeralToArabicNumberDto.getRomanNumeral());
    }

    @Test
    void testGetRomanNumeralForThousandths() {
        ResponseEntity responseEntity = rmConverterController.getRomanNumeral(1110);
        assertEquals(200, responseEntity.getStatusCodeValue());
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals("MCX", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getRomanNumeral(2207);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("MMCCVII", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getRomanNumeral(1865);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("MDCCCLXV", romanNumeralToArabicNumberDto.getRomanNumeral());
    }


}
