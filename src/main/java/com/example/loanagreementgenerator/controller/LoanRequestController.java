package com.example.loanagreementgenerator.controller;

import com.example.loanagreementgenerator.service.LoanRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoanRequestController {

    LoanRequestService service;

    @GetMapping("/generate-agreement/{id}")
    public ResponseEntity<HttpStatus> generateAgreement(@RequestParam UUID id){
        //TODO
        service.findById(id);
        return ResponseEntity.ok().build();
    }

}
