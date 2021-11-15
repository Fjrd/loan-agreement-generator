package com.example.loanagreementgenerator.service;

import com.example.loanagreementgenerator.domain.LoanRequest;
import com.example.loanagreementgenerator.dto.LoanRequestDto;

import java.util.UUID;

public interface LoanRequestService {
    public SomePDFclass findById(UUID id);
}
