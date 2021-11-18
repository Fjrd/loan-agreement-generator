package com.example.loanagreementgenerator.controller;

import com.example.loanagreementgenerator.service.LoanRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoanRequestController {

    private final LoanRequestService service;

    @GetMapping(value = "/generate-agreement/{id}")
    public ResponseEntity<byte[]> generateAgreement(@PathVariable UUID id){
        log.info("generateAgreement(), id = {}", id);

        byte[] file = service.findByIdAndGetAgreementPdf(id);

        return file == null ?
                ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build() :
                ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline;attachment; filename=agreement.pdf")
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(file);
    }
}
