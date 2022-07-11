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
}
