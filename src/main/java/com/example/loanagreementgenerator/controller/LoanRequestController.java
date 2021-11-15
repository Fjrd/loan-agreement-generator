package com.example.loanagreementgenerator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoanRequestController {

    @GetMapping("/generate-agreement/{id}")
    public SomePDFClass generateAgreement(@RequestParam UUID id){
        //TODO
    }

}
