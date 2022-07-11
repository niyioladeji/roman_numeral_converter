package com.adeniyi.rnconverter.controller;

import com.adeniyi.rnconverter.dto.RomanNumeralToArabicNumberDto;
import com.adeniyi.rnconverter.service.RomanNumeralConverterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
class RomanNumeralConverterControllerTest {
    static final String INVALID_ROMAN_NUMERAL_MSG =
            "Roman Numeral cannot be generated for the provided number";
    static final String INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG =
            "Invalid Roman numeral. Cannot convert to integer";
    @InjectMocks
    private RomanNumeralConverterController rmConverterController;
    @Spy
    private RomanNumeralConverterService romanNumeralConverterService;

    @Test
    void testGetRomanNumeralForOutOfRange() {
        ResponseEntity responseEntity = rmConverterController.getIntegerFromRomanNumeral(-1);
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_MSG, responseEntity.getBody().toString());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral(3001);
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_MSG, responseEntity.getBody().toString());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral(0);
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_MSG, responseEntity.getBody().toString());

    }

    @Test
    void testGetRomanNumeralSmallInteger() {
        ResponseEntity responseEntity = rmConverterController.getIntegerFromRomanNumeral(10);
        assertEquals(200, responseEntity.getStatusCodeValue());
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals("X", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral(7);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("VII", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral(65);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("LXV", romanNumeralToArabicNumberDto.getRomanNumeral());
    }

    @Test
    void testGetRomanNumeralForHundredths() {
        ResponseEntity responseEntity = rmConverterController.getIntegerFromRomanNumeral(100);
        assertEquals(200, responseEntity.getStatusCodeValue());
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals("C", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral(207);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("CCVII", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral(865);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("DCCCLXV", romanNumeralToArabicNumberDto.getRomanNumeral());
    }

    @Test
    void testGetRomanNumeralForThousandths() {
        ResponseEntity responseEntity = rmConverterController.getIntegerFromRomanNumeral(1110);
        assertEquals(200, responseEntity.getStatusCodeValue());
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals("MCX", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral(2207);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("MMCCVII", romanNumeralToArabicNumberDto.getRomanNumeral());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral(1865);
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("MDCCCLXV", romanNumeralToArabicNumberDto.getRomanNumeral());
    }

    @Test
    void testInvalidGetIntegerRomanNumeral() {
        ResponseEntity responseEntity = rmConverterController.getIntegerFromRomanNumeral("IIXX");
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, responseEntity.getBody().toString());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral("CCCC");
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, responseEntity.getBody().toString());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral("CCCLC");
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, responseEntity.getBody().toString());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral("CCCIC");
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals(INVALID_ROMAN_NUMERAL_TO_INTEGER_MSG, responseEntity.getBody().toString());
    }

    @Test
    void testGetIntegerForSmallRomanNumeral() {
        ResponseEntity responseEntity = rmConverterController.getIntegerFromRomanNumeral("X");
        assertEquals(200, responseEntity.getStatusCodeValue());
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(10, romanNumeralToArabicNumberDto.getArabicNumber());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral("VII");
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(7, romanNumeralToArabicNumberDto.getArabicNumber());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral("LXV");
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(65, romanNumeralToArabicNumberDto.getArabicNumber());
    }

    @Test
    void testGetIntegerForRomanNumeralForHundredths() {
        ResponseEntity responseEntity = rmConverterController.getIntegerFromRomanNumeral("C");
        assertEquals(200, responseEntity.getStatusCodeValue());
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(100, romanNumeralToArabicNumberDto.getArabicNumber());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral("CCVII");
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(207, romanNumeralToArabicNumberDto.getArabicNumber());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral("DCCCLXV");
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(865, romanNumeralToArabicNumberDto.getArabicNumber());
    }

    @Test
    void testGetIntegerForRomanNumeralForThousandths() {
        ResponseEntity responseEntity = rmConverterController.getIntegerFromRomanNumeral("MCX");
        assertEquals(200, responseEntity.getStatusCodeValue());
        RomanNumeralToArabicNumberDto romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(1110, romanNumeralToArabicNumberDto.getArabicNumber());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral("MMCCVII");
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(2207, romanNumeralToArabicNumberDto.getArabicNumber());
        responseEntity = rmConverterController.getIntegerFromRomanNumeral("MDCCCLXV");
        romanNumeralToArabicNumberDto
                = (RomanNumeralToArabicNumberDto)responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(1865, romanNumeralToArabicNumberDto.getArabicNumber());
    }


}
