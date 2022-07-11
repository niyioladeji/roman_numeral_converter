package com.adeniyi.rnconverter.controller;

import com.adeniyi.rnconverter.dto.RomanNumeralToArabicNumberDto;
import com.adeniyi.rnconverter.service.RomanNumeralConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * The RomanNumeralConverterController provides simple restful API for converting
 * integer to and from roman numeral number notations.
 *
 * Suitable for
 *      -   converting integers between 1 - 3000 to roman numeral string
 *      -   converting any valid roman numeral string to an integer
 *
 * @author  Adeniyi Oladeji
 * @version 0.0.1
 * @since   2022-07-11
 */
@RestController
@RequestMapping("api/rnconverter")
public class RomanNumeralConverterController {

    @Autowired
    private RomanNumeralConverterService  romanNumeralConverterService;

    @GetMapping(path = "/getRomanNumeral/{input}", produces = "application/json")
    public ResponseEntity getRomanNumeral(@PathVariable int input) {
        try {
            String romanNumeral = romanNumeralConverterService.getRomanNumeralForInteger(input);
            RomanNumeralToArabicNumberDto dto = new RomanNumeralToArabicNumberDto();
            dto.setArabicNumber(input);
            dto.setRomanNumeral(romanNumeral);
            return ResponseEntity.ok(dto);
        }catch (Exception ex) {
            return new ResponseEntity<>(
                    "Roman Numeral cannot be generated for the provided number",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/getRomanNumeral/{input}", produces = "application/json")
    public ResponseEntity getRomanNumeral(@PathVariable String input) {
        try {
            int romanNumeral = romanNumeralConverterService.getIntegerFromRomanNumeral(input);
            RomanNumeralToArabicNumberDto dto = new RomanNumeralToArabicNumberDto();
            dto.setArabicNumber(romanNumeral);
            dto.setRomanNumeral(input);
            return ResponseEntity.ok(dto);
        }catch (Exception ex) {
            return new ResponseEntity<>(
                    ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
